package com.dxt.comment_boot.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "business")
public class Business {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 图片文件名
     */
    @Column(name = "img_file_name")
    private String imgFileName;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 价格(单位：元)
     */
    private BigDecimal price;

    /**
     * 距离(单位：米)
     */
    private Integer distance;

    /**
     * 已售数量
     */
    private Integer number;

    /**
     * 描述
     */
    private String desc;

    /**
     * 城市
     */
    private String city;

    /**
     * 类别
     */
    private String category;

    /**
     * 评论星星总数
     */
    @Column(name = "star_total_num")
    private Integer starTotalNum;

    /**
     * 评论总次数
     */
    @Column(name = "comment_total_num")
    private Integer commentTotalNum;

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
     * 获取副标题
     *
     * @return subtitle - 副标题
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 设置副标题
     *
     * @param subtitle 副标题
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 获取价格(单位：元)
     *
     * @return price - 价格(单位：元)
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格(单位：元)
     *
     * @param price 价格(单位：元)
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取距离(单位：米)
     *
     * @return distance - 距离(单位：米)
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * 设置距离(单位：米)
     *
     * @param distance 距离(单位：米)
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * 获取已售数量
     *
     * @return number - 已售数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置已售数量
     *
     * @param number 已售数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 获取描述
     *
     * @return desc - 描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置描述
     *
     * @param desc 描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取类别
     *
     * @return category - 类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置类别
     *
     * @param category 类别
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取评论星星总数
     *
     * @return star_total_num - 评论星星总数
     */
    public Integer getStarTotalNum() {
        return starTotalNum;
    }

    /**
     * 设置评论星星总数
     *
     * @param starTotalNum 评论星星总数
     */
    public void setStarTotalNum(Integer starTotalNum) {
        this.starTotalNum = starTotalNum;
    }

    /**
     * 获取评论总次数
     *
     * @return comment_total_num - 评论总次数
     */
    public Integer getCommentTotalNum() {
        return commentTotalNum;
    }

    /**
     * 设置评论总次数
     *
     * @param commentTotalNum 评论总次数
     */
    public void setCommentTotalNum(Integer commentTotalNum) {
        this.commentTotalNum = commentTotalNum;
    }
}