package com.admin.crawler.entity;

import com.admin.crawler.annotations.OrderType;


public class OrderByInfo {
    private String []by;
    private OrderType orderType;

    public OrderByInfo() {
    }

    public OrderByInfo(String[] by, OrderType orderType) {
        this.by = by;
        this.orderType = orderType;
    }

    public String[] getBy() {
        return by;
    }

    public void setBy(String[] by) {
        this.by = by;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }
}

