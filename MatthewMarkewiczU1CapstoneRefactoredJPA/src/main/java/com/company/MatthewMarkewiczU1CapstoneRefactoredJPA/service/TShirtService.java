package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service;

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

    public TShirt saveTShirt(TShirt tShirt) throws Exception {
        try {
            return tShirtDao.addTShirt(tShirt);
        } catch (Exception e) {
            throw new Exception("Couldn't add T-Shirt to database");
        }
    }

    public List<TShirt> findAllTShirts() {
        return tShirtDao.getAllTShirts();
    }

    public TShirt findTShirtById(int id) throws Exception {
        try {
            return tShirtDao.getTShirt(id);
        } catch (Exception e) {
            throw new Exception("No shirts with that ID in the database");
        }
    }

    public List<TShirt> findTShirtsByColor(String color) throws Exception {
        if (tShirtDao.getTShirtsByColor(color).size() == 0) {
            throw new Exception("No shirts with that color in database");
        } else {
            return tShirtDao.getTShirtsByColor(color);
        }
    }

    public List<TShirt> findTShirtsBySize(String size) throws Exception {
        if (tShirtDao.getTShirtsBySize(size).size() == 0) {
            throw new Exception("No shirts with that size in database");
        } else {
            return tShirtDao.getTShirtsBySize(size);
        }
    }

    public void updateTShirt(TShirt tShirt) {
        tShirtDao.updateTShirt(tShirt);
    }

    public void deleteTShirt(int id) {
        tShirtDao.deleteTShirt(id);
    }
}
