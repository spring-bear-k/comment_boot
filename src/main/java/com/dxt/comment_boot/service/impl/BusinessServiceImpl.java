package com.dxt.comment_boot.service.impl;

import com.dxt.comment_boot.entity.Business;
import com.dxt.comment_boot.mapper.BusinessMapper;
import com.dxt.comment_boot.service.BusinessService;
import com.dxt.comment_boot.vo.BusinessVo;
import com.dxt.comment_boot.vo.HomeList;
import com.dxt.comment_boot.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public HomeList<BusinessVo> getBusinessList(Integer pageNum, Integer pageSize, String city, String category, String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        List<Business> businesses=new ArrayList<>();
        if (category==null&&keyword==null){
            businesses=businessMapper.getBusinessList(city,null,null);
        }else if (category.trim().equals("all")){
            businesses=businessMapper.getBusinessList(city,null,keyword);
        }else if (category!="all"){
            businesses=businessMapper.getBusinessList(city,category,keyword);
        }
        PageInfo<Business> pageInfo=new PageInfo<>(businesses);
        List<BusinessVo> businessVos=new ArrayList<>();
        for (Business business:pageInfo.getList()){
            BusinessVo businessVo=new BusinessVo();
            BeanUtils.copyProperties(business,businessVo);
            Page page1=new Page();
            businessVo.setPage(page1);
            businessVo.setImg("http://localhost:8081/upload/business/"+business.getImgFileName());
            businessVos.add(businessVo);
        }
        HomeList<BusinessVo> homeList=new HomeList<>();
        homeList.setHasMore(false);
        homeList.setData(businessVos);
        return homeList;
    }

    @Override
    public BusinessVo getBusiness(Integer id) {
        Business business=businessMapper.selectByKey(id);
        BusinessVo businessVo=new BusinessVo();
        BeanUtils.copyProperties(business,businessVo);
        Page page=new Page();
        businessVo.setPage(page);
        businessVo.setImg("http://localhost:8081/upload/business/"+business.getImgFileName());
        return businessVo;
    }

    @Override
    public PageInfo<Business> selectBusiness(String title, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageInfo pageInfo=new PageInfo(businessMapper.getBusinessList(null,null,title));
        return pageInfo;
    }

    @Override
    public Business selectBusiness(Integer id) {
        return businessMapper.selectByKey(id);
    }

    @Override
    public boolean updateBusiness(Business business) {
        return businessMapper.updateBusiness(business)>0;
    }

    @Override
    public boolean insertBusiness(Business business) {
        return businessMapper.insertBusiness(business)>0;
    }

    @Override
    public boolean deleteBusiness(Integer id) {
        return businessMapper.deleteByPrimaryKey(id)>0;
    }
}
