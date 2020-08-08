package com.dxt.comment_boot.service;

import com.dxt.comment_boot.entity.SysMenu;

import java.util.List;

public interface SysMenuService {
    public List<SysMenu> selectSysMenu(Integer groupId);
}
