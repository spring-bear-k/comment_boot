package com.dxt.comment_boot.vo;

import com.dxt.comment_boot.entity.Ad;

public class AdVo extends Ad {

    private String img;
    private Page page;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
