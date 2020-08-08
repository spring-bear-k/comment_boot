package com.dxt.comment_boot.vo;

import com.dxt.comment_boot.entity.Business;

public class BusinessVo extends Business {

    private String img;
    private Integer mumber;
    private Integer star;
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getMumber() {
        return mumber;
    }

    public void setMumber(Integer mumber) {
        this.mumber = mumber;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
