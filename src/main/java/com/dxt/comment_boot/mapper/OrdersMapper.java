package com.dxt.comment_boot.mapper;

import com.dxt.comment_boot.entity.Orders;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface OrdersMapper extends Mapper<Orders> {
    public List<Map<String,Object>> getOrders();
}