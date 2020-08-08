package com.dxt.comment_boot.vo;

public class Page {
    private Integer totalNumber;
    private Integer currentPage;
    private Integer totalPage;
    private Integer pageNumber;

    public Page() {
        this.totalNumber = 0;
        this.currentPage = 1;
        this.totalPage = 0;
        this.pageNumber = 5;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
