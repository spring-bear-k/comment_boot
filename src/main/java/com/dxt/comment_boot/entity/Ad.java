package com.dxt.comment_boot.entity;

import javax.persistence.*;

@Table(name = "ad")
public class Ad {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片文件名
     */
    @Column(name = "img_file_name")
    private String imgFileName;

    /**
     * 链接地址
     */
    private String link;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取图片文件名
     *
     * @return img_file_name - 图片文件名
     */
    public String getImgFileName() {
        return imgFileName;
    }

    /**
     * 设置图片文件名
     *
     * @param imgFileName 图片文件名
     */
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }

    /**
     * 获取链接地址
     *
     * @return link - 链接地址
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置链接地址
     *
     * @param link 链接地址
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取权重
     *
     * @return weight - 权重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置权重
     *
     * @param weight 权重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}