package com.dxt.comment_boot.entity;

import javax.persistence.*;

@Table(name = "sys_action")
public class SysAction {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 动作名称
     */
    private String name;

    /**
     * 动作地址
     */
    private String url;

    @Column(name = "menu_id")
    private Integer menuId;

    private String method;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取动作名称
     *
     * @return name - 动作名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置动作名称
     *
     * @param name 动作名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取动作地址
     *
     * @return url - 动作地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置动作地址
     *
     * @param url 动作地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return menu_id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * @param menuId
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * @return method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method
     */
    public void setMethod(String method) {
        this.method = method;
    }
}