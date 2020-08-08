package com.dxt.comment_boot.vo;

import com.dxt.comment_boot.entity.Comment;

public class CommentVo extends Comment {

    private Page page;
    private OrdersVo ordersVo;
    private String username;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public OrdersVo getOrdersVo() {
        return ordersVo;
    }

    public void setOrdersVo(OrdersVo ordersVo) {
        this.ordersVo = ordersVo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
