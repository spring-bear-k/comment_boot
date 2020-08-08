package com.dxt.comment_boot.service.impl;

import com.dxt.comment_boot.entity.SysUser;
import com.dxt.comment_boot.mapper.SysUserMapper;
import com.dxt.comment_boot.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser login(String name, String password) {
        Example example=new Example(SysUser.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("name",name);
        criteria.andEqualTo("password",password);
        return sysUserMapper.selectOneByExample(example);
    }
}
