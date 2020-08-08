package com.dxt.comment_boot.service;

import com.dxt.comment_boot.entity.Business;
import com.dxt.comment_boot.vo.BusinessVo;
import com.dxt.comment_boot.vo.HomeList;
import com.github.pagehelper.PageInfo;


public interface BusinessService {
    public HomeList<BusinessVo> getBusinessList(Integer pageNum, Integer pageSize, String city, String category, String keyword);
    public BusinessVo getBusiness(Integer id);
    public PageInfo<Business> selectBusiness(String title, Integer pageNum, Integer pageSize);
    public Business selectBusiness(Integer id);
    public boolean updateBusiness(Business business);
    public boolean insertBusiness(Business business);
    public boolean deleteBusiness(Integer id);
}
