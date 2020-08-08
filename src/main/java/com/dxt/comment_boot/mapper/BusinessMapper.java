package com.dxt.comment_boot.mapper;

import com.dxt.comment_boot.entity.Business;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BusinessMapper extends Mapper<Business> {
    Business selectByKey(Integer id);
    public int updateBusiness(@Param("business") Business business);
    public int insertBusiness(@Param("business") Business business);
    public int deleteBusiness(Integer id);
    List<Business> getBusinessList(@Param("city") String city, @Param("category") String category, @Param("title") String keyword);
}