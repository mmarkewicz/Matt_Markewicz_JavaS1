package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.TShirt;

import java.util.List;

public interface TShirtDao {
    TShirt addTShirt(TShirt tShirt);
    TShirt getTShirt(int id);
    List<TShirt> getAllTShirts();
    void updateTShirt(TShirt tShirt);
    void deleteTShirt(int id);
    List<TShirt> getTShirtsBySize(String size);
    List<TShirt> getTShirtsByColor(String color);
}
