package com.yuhong.dao;
 
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.yuhong.model.Toy;
 
@Repository
public class ToyDAOImpl implements ToyDAO {

    @Autowired
    private SessionFactory sessionFactory;
 
    public void addToy(Toy toy) {
        sessionFactory.getCurrentSession().saveOrUpdate(toy);
 
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Toy> getAllToys() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Toy")
                .list();
    }


    @Override
    public void deleteToy(Integer ToyId) {
        Toy toy = (Toy) sessionFactory.getCurrentSession().load(
                Toy.class, ToyId);
        if (null != toy) {
            this.sessionFactory.getCurrentSession().delete(toy);
        }
 
    }
 
    public Toy getToy(int ToyId) {
        return (Toy) sessionFactory.getCurrentSession().get(
                Toy.class, ToyId);
    }
 
    @Override
    public Toy updateToy(Toy toy) {
        sessionFactory.getCurrentSession().update(toy);
        return toy;
    }
 
}