package com.dxt.comment_boot.vo;

import java.util.List;

public class HomeList<T> {
    private boolean hasMore;
    private List<T> data;

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
