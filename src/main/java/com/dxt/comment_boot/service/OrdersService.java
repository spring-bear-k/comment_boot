package com.dxt.comment_boot.service;

import com.dxt.comment_boot.vo.OrdersVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface OrdersService {
    public boolean insertOrder(Integer id, String phone, Integer num, BigDecimal price);
    public List<OrdersVo> getOrdersList(String phone);
    public List<Map<String,Object>> getOrders();
}
