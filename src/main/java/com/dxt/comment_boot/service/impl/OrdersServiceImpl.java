package com.dxt.comment_boot.service.impl;

import com.dxt.comment_boot.entity.Business;
import com.dxt.comment_boot.entity.Member;
import com.dxt.comment_boot.entity.Orders;
import com.dxt.comment_boot.mapper.BusinessMapper;
import com.dxt.comment_boot.mapper.MemberMapper;
import com.dxt.comment_boot.mapper.OrdersMapper;
import com.dxt.comment_boot.service.OrdersService;
import com.dxt.comment_boot.vo.OrdersVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public boolean insertOrder(Integer id, String phone, Integer num, BigDecimal price) {
        Example example=new Example(Member.class);
        Example.Criteria criteria=example.createCriteria();
        if (StringUtils.isNotBlank(phone)){
            criteria.andEqualTo("phone",phone);
        }
        Orders orders=new Orders();
        orders.setBusinessId(id);
        orders.setMemberId(memberMapper.selectOneByExample(example).getId());
        orders.setNum(num);
        orders.setPrice(price);
        orders.setCommentState(0);
        if (ordersMapper.insertSelective(orders)>0){
            return true;
        }
        return false;
    }

    @Override
    public List<OrdersVo> getOrdersList(String phone) {
        Example example=new Example(Member.class);
        Example.Criteria criteria=example.createCriteria();
        if (StringUtils.isNotBlank(phone)){
            criteria.andEqualTo("phone",phone);
        }
        Integer mId=memberMapper.selectOneByExample(example).getId();
        Example example1=new Example(Orders.class);
        Example.Criteria criteria1=example1.createCriteria();
        if (mId!=null){
            criteria1.andEqualTo("memberId",mId);
        }
        List<Orders> ordersList=ordersMapper.selectByExample(example1);
        List<OrdersVo> ordersVoList=new ArrayList<>();
        for (Orders orders:ordersList){
            OrdersVo ordersVo=new OrdersVo();
            BeanUtils.copyProperties(orders,ordersVo);
            Business business=businessMapper.selectByKey(orders.getBusinessId());
            ordersVo.setBusiness(business);
            ordersVo.setCount(0);
            ordersVo.setImg("http://localhost:8081/upload/business/"+business.getImgFileName());
            ordersVo.setTitle(business.getTitle());
            ordersVoList.add(ordersVo);
        }
        return ordersVoList;
    }

    @Override
    public List<Map<String, Object>> getOrders() {
        return ordersMapper.getOrders();
    }
}
