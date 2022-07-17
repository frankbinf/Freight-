package com.bin.dto;

import com.bin.pojo.Order;
import com.bin.pojo.OrderDetail;

import java.util.List;

public class OrderDto extends Order {
    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
