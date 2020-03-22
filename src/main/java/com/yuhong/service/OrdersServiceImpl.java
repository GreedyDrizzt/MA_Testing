package com.yuhong.service;
import java.util.List;

import com.yuhong.dao.OrdersDAO;
import com.yuhong.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDAO ordersDAO;

    @Override
    @Transactional
    public void addOrders(Orders orders) {
        ordersDAO.addOrders(orders);
    }

    @Override
    @Transactional
    public List<Orders> getAllOrders() {
        return ordersDAO.getAllOrders();
    }

    @Override
    @Transactional
    public void deleteOrders(Integer OrdersId) {
        ordersDAO.deleteOrders(OrdersId);
    }

    public Orders getOrders(int OrdersId) {
        return ordersDAO.getOrders(OrdersId);
    }

    public Orders updateOrders(Orders orders) {
        return ordersDAO.updateOrders(orders);
    }

    public void setOrdersDAO(OrdersDAO ordersDAO) {
        this.ordersDAO = ordersDAO;
    }
}
