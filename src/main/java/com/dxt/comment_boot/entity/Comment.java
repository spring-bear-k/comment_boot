package com.dxt.comment_boot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "comment")
public class Comment {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "orders_id")
    private Integer ordersId;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 星级评分
     */
    private Integer star;

    @Column(name = "create_time")
    private Date createTime;

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
     * 获取用户名
     *
     * @return orders_id - 用户名
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * 设置用户名
     *
     * @param ordersId 用户名
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * 获取评论内容
     *
     * @return comment - 评论内容
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置评论内容
     *
     * @param comment 评论内容
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取星级评分
     *
     * @return star - 星级评分
     */
    public Integer getStar() {
        return star;
    }

    /**
     * 设置星级评分
     *
     * @param star 星级评分
     */
    public void setStar(Integer star) {
        this.star = star;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}