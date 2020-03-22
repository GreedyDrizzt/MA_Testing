package com.yuhong.dao;

import com.yuhong.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class OrdersDAOImpl implements OrdersDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void addOrders(Orders orders) {
        sessionFactory.getCurrentSession().saveOrUpdate(orders);

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Orders> getAllOrders() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Orders").list();
    }

    @Override
    public void deleteOrders(Integer OrdersId) {
        Orders orders = (Orders) sessionFactory.getCurrentSession().load(
                Orders.class, OrdersId);
        if (null != orders) {
            this.sessionFactory.getCurrentSession().delete(orders);
        }

    }

    public Orders getOrders(int OrdersId) {
        return (Orders) sessionFactory.getCurrentSession().get(
                Orders.class, OrdersId);
    }

    @Override
    public Orders updateOrders(Orders orders) {
        sessionFactory.getCurrentSession().update(orders);
        return orders;
    }
}
