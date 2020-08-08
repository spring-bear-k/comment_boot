package com.dxt.comment_boot.service.impl;

import com.dxt.comment_boot.entity.Ad;
import com.dxt.comment_boot.mapper.AdMapper;
import com.dxt.comment_boot.service.AdService;
import com.dxt.comment_boot.vo.AdVo;
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
public class AdServiceImpl implements AdService {
    @Autowired
    private AdMapper adMapper;
    @Override
    public List<AdVo> getAdList() {
        List<Ad> ads=adMapper.selectAll();
        List<AdVo> adVos=new ArrayList<>();
        for (Ad ad:ads){
            AdVo adVo=new AdVo();
            BeanUtils.copyProperties(ad,adVo);
            adVo.setImg("http://localhost:8081/upload/ad/"+ad.getImgFileName());
            Page page=new Page();
            adVo.setPage(page);
            adVos.add(adVo);
        }
        return adVos;
    }

    @Override
    public PageInfo<Ad> selectAdList(String title, Integer pageNum, Integer pageSize) {
        Example example=new Example(Ad.class);
        Example.Criteria criteria=example.createCriteria();
        if (StringUtils.isNotBlank(title)){
            criteria.andLike("title","%"+title+"%");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Ad> adList=adMapper.selectByExample(example);
        PageInfo pageInfo=new PageInfo(adList);
        return pageInfo;
    }

    @Override
    public Ad getAd(Integer id) {
        return adMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateAd(Ad ad) {
        return adMapper.updateByPrimaryKey(ad)>0;
    }

    @Override
    public boolean deleteAd(Integer id) {
        return adMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean insertAd(Ad ad) {
        return adMapper.insertSelective(ad)>0;
    }

}
