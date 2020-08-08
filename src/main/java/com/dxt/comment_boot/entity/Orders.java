package com.dxt.comment_boot.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "orders")
public class Orders {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 商户主键
     */
    @Column(name = "business_id")
    private Integer businessId;

    /**
     * 会员主键
     */
    @Column(name = "member_id")
    private Integer memberId;

    /**
     * 消费人数
     */
    private Integer num;

    /**
     * 评论状态 -- 0：未评论 2：已评论
     */
    @Column(name = "comment_state")
    private Integer commentState;

    /**
     * 价格(消费金额)
     */
    private BigDecimal price;

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
     * 获取商户主键
     *
     * @return business_id - 商户主键
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置商户主键
     *
     * @param businessId 商户主键
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取会员主键
     *
     * @return member_id - 会员主键
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置会员主键
     *
     * @param memberId 会员主键
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取消费人数
     *
     * @return num - 消费人数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置消费人数
     *
     * @param num 消费人数
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取评论状态 -- 0：未评论 2：已评论
     *
     * @return comment_state - 评论状态 -- 0：未评论 2：已评论
     */
    public Integer getCommentState() {
        return commentState;
    }

    /**
     * 设置评论状态 -- 0：未评论 2：已评论
     *
     * @param commentState 评论状态 -- 0：未评论 2：已评论
     */
    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    /**
     * 获取价格(消费金额)
     *
     * @return price - 价格(消费金额)
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格(消费金额)
     *
     * @param price 价格(消费金额)
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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