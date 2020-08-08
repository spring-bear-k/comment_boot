package com.dxt.comment_boot.vo;

import com.dxt.comment_boot.entity.Business;
import com.dxt.comment_boot.entity.Member;
import com.dxt.comment_boot.entity.Orders;

public class OrdersVo extends Orders {

    private Member member;
    private Business business;
    private String img;
    private String title;
    private Integer count;

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
