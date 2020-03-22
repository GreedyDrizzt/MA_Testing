package com.yuhong.dao;

import java.util.List;
import com.yuhong.model.Orders;

public interface OrdersDAO {
    public void addOrders(Orders orders);

    public List<Orders> getAllOrders();

    public void deleteOrders(Integer OrdersId);

    public Orders getOrders(int OrdersId);

    public Orders updateOrders(Orders orders);
}
