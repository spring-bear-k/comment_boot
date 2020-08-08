package com.dxt.comment_boot.service;

import com.dxt.comment_boot.entity.SysUser;

public interface SysUserService {
    public SysUser login(String name, String password);
}
