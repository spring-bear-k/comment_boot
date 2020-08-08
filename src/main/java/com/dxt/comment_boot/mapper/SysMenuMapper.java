package com.dxt.comment_boot.mapper;

import com.dxt.comment_boot.entity.SysMenu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {
    public List<SysMenu> selectSysMenu(Integer groupId);
}
