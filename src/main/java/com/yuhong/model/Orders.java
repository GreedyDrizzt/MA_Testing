package com.yuhong.model;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="order_id", nullable = false)
    private int order_id;

    @Column(name = "toy_type", nullable = false)
    private String toy_type;

    @Column(name = "order_date", nullable = false)
    private java.sql.Date order_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int id) {
        this.order_id = id;
    }

    public String getToy_type() {
        return toy_type;
    }

    public void setToy_type(String toy_type) {
        this.toy_type = toy_type;
    }

    public java.sql.Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(java.sql.Date order_date) {
        this.order_date = order_date;
    }
}
