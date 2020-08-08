package com.dxt.comment_boot.service.impl;

import com.dxt.comment_boot.entity.Comment;
import com.dxt.comment_boot.entity.Member;
import com.dxt.comment_boot.entity.Orders;
import com.dxt.comment_boot.mapper.BusinessMapper;
import com.dxt.comment_boot.mapper.CommentMapper;
import com.dxt.comment_boot.mapper.MemberMapper;
import com.dxt.comment_boot.mapper.OrdersMapper;
import com.dxt.comment_boot.service.CommentService;
import com.dxt.comment_boot.vo.CommentVo;
import com.dxt.comment_boot.vo.HomeList;
import com.dxt.comment_boot.vo.OrdersVo;
import com.dxt.comment_boot.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public HomeList<CommentVo> getCommentList(Integer page, Integer pageSize, Integer id) {
        Example example=new Example(Orders.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("businessId",id);
        PageHelper.startPage(page,pageSize);
        List<Orders> ordersList=ordersMapper.selectByExample(example);
        PageInfo<Orders> pageInfo=new PageInfo<>(ordersList);
        List<CommentVo> commentVoList=new ArrayList<>();
        for (Orders orders:pageInfo.getList()){
            OrdersVo ordersVo=new OrdersVo();
            BeanUtils.copyProperties(orders,ordersVo);
            Member member=memberMapper.selectByPrimaryKey(orders.getMemberId());
            ordersVo.setMember(member);
            CommentVo commentVo=new CommentVo();
            Example example1=new Example(Comment.class);
            Example.Criteria criteria1=example1.createCriteria();
            criteria1.andEqualTo("ordersId",orders.getId());
            BeanUtils.copyProperties(commentMapper.selectOneByExample(example1),commentVo);
            commentVo.setOrdersVo(ordersVo);
            Page page1=new Page();
            commentVo.setPage(page1);
            commentVo.setUsername(member.getName());
            commentVoList.add(commentVo);
        }
        HomeList homeList=new HomeList();
        homeList.setHasMore(false);
        homeList.setData(commentVoList);
        return homeList;
    }

    @Override
    public boolean insertComment(Integer id, String comment, Integer star) {
        Comment comment1=new Comment();
        comment1.setOrdersId(id);
        comment1.setComment(comment);
        comment1.setStar(star);
        Orders orders=new Orders();
        orders.setId(id);
        orders.setCommentState(2);
        if (ordersMapper.updateByPrimaryKeySelective(orders)>0&&commentMapper.insertSelective(comment1)>0){
            return true;
        }
        return false;
    }

    @Override
    public PageInfo<CommentVo> selectComment(String title, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example=new Example(Comment.class);
        Example.Criteria criteria=example.createCriteria();
        if (StringUtils.isNotBlank(title)){
            criteria.andEqualTo("comment",title);
        }
        List<Comment> commentList=commentMapper.selectByExample(example);
        List<CommentVo> commentVoList=new ArrayList<>();
        for (Comment comment:commentList){
            CommentVo commentVo=new CommentVo();
            BeanUtils.copyProperties(comment,commentVo);
            OrdersVo ordersVo=new OrdersVo();
            Orders orders=ordersMapper.selectByPrimaryKey(comment.getOrdersId());
            BeanUtils.copyProperties(orders,ordersVo);
            ordersVo.setBusiness(businessMapper.selectByKey(orders.getBusinessId()));
            ordersVo.setMember(memberMapper.selectByPrimaryKey(orders.getMemberId()));
            commentVo.setOrdersVo(ordersVo);
            commentVoList.add(commentVo);
        }
        PageInfo pageInfo=new PageInfo(commentVoList);
        return pageInfo;
    }
    @Override
    public boolean deleteComment(Integer id) {
        return commentMapper.deleteByPrimaryKey(id)>0;
    }
}
