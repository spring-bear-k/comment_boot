package com.dxt.comment_boot.service.impl;

import com.dxt.comment_boot.entity.SysMenu;
import com.dxt.comment_boot.mapper.SysMenuMapper;
import com.dxt.comment_boot.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> selectSysMenu(Integer groupId) {
        return sysMenuMapper.selectSysMenu(groupId);
    }
}
