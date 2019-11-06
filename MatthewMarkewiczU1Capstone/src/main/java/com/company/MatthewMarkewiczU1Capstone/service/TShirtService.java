package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.TShirtDao;
import com.company.MatthewMarkewiczU1Capstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtService {

    TShirtDao tShirtDao;

    @Autowired
    public TShirtService(TShirtDao tShirtDao) {
        this.tShirtDao = tShirtDao;
    }

    public TShirt saveTShirt(TShirt tShirt) {
        return tShirtDao.addTShirt(tShirt);
    }

    public List<TShirt> findAllTShirts() {
        return tShirtDao.getAllTShirts();
    }

    public TShirt findTShirtById(int id) {
        return tShirtDao.getTShirt(id);
    }

    public List<TShirt> findTShirtsByColor(String color) {
        return tShirtDao.getTShirtsByColor(color);
    }

    public List<TShirt> findTShirtsBySize(String size) {
        return tShirtDao.getTShirtsBySize(size);
    }

    public void updateTShirt(TShirt tShirt) {
        tShirtDao.updateTShirt(tShirt);
    }

    public void deleteTShirt(int id) {
        tShirtDao.deleteTShirt(id);
    }
}
