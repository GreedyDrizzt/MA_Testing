package com.yuhong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuhong.dao.ToyDAO;
import com.yuhong.model.Toy;

@Service
@Transactional
public class ToyServiceImpl implements ToyService {

    @Autowired
    private ToyDAO toyDAO;

    @Override
    @Transactional
    public void addToy(Toy toy) {
	toyDAO.addToy(toy);
    }

    @Override
    @Transactional
    public List<Toy> getAllToys() {
	return toyDAO.getAllToys();
    }

    @Override
    @Transactional
    public void deleteToy(Integer ToyId) {
	toyDAO.deleteToy(ToyId);
    }

    public Toy getToy(int ToyId) {
	return toyDAO.getToy(ToyId);
    }

    public Toy updateToy(Toy toy) {
	return toyDAO.updateToy(toy);
    }

    public void setToyDAO(ToyDAO toyDAO) {
	this.toyDAO = toyDAO;
    }
}
