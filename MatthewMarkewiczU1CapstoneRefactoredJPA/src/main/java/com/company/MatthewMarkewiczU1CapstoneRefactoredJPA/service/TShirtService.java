package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao.TShirtRepository;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TShirtService {

    TShirtRepository tShirtRepository;

    @Autowired
    public TShirtService(TShirtRepository tshirtRepository) {
        this.tShirtRepository = tshirtRepository;
    }

    public TShirt saveTShirt(TShirt tShirt) throws Exception {
        try {
            return tShirtRepository.save(tShirt);
        } catch (Exception e) {
            throw new Exception("Couldn't add T-Shirt to database");
        }
    }

    public List<TShirt> findAllTShirts() {
        return tShirtRepository.findAll();
    }

    public TShirt findTShirtById(int id) throws Exception {
        try {
            return tShirtRepository.getOne(id);
        } catch (Exception e) {
            throw new Exception("No shirts with that ID in the database");
        }
    }

    public List<TShirt> findTShirtsByColor(String color) throws Exception {
        if (tShirtRepository.findByColor(color).size() == 0) {
            throw new Exception("No shirts with that color in database");
        } else {
            return tShirtRepository.findByColor(color);
        }
    }

    public List<TShirt> findTShirtsBySize(String size) throws Exception {
        if (tShirtRepository.findBySize(size).size() == 0) {
            throw new Exception("No shirts with that size in database");
        } else {
            return tShirtRepository.findBySize(size);
        }
    }

    public void updateTShirt(TShirt tShirt) {
        tShirtRepository.save(tShirt);
    }

    public void deleteTShirt(int id) {
        tShirtRepository.deleteById(id);
    }
}
