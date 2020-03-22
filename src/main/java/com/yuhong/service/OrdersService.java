package com.yuhong.service;

import java.util.List;

import com.yuhong.dao.OrdersDAO;
import com.yuhong.model.Orders;

public interface OrdersService {

    public void addOrders(Orders orders);

    public List<Orders> getAllOrders();

    public void deleteOrders(Integer OrdersId);

    public Orders getOrders(int Ordersid);

    public Orders updateOrders(Orders orders);

    public void setOrdersDAO(OrdersDAO ordersDAO);
}