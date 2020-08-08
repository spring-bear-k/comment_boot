package com.dxt.comment_boot.service;

import com.dxt.comment_boot.entity.Ad;
import com.dxt.comment_boot.vo.AdVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdService {
    public List<AdVo> getAdList();
    public PageInfo<Ad> selectAdList(String title, Integer pageNum, Integer pageSize);
    public Ad getAd(Integer id);
    public boolean updateAd(Ad ad);
    public boolean deleteAd(Integer id);
    public boolean insertAd(Ad ad);
}
