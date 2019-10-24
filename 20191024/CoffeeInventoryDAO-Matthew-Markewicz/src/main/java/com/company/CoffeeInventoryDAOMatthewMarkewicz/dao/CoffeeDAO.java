package com.company.CoffeeInventoryDAOMatthewMarkewicz.dao;

import com.company.CoffeeInventoryDAOMatthewMarkewicz.model.Coffee;

import java.util.List;

public interface CoffeeDAO {
    Coffee getCoffee(int id);
    List<Coffee> getAllCoffees();
    Coffee addCoffee(Coffee coffee);
    void updateCoffee(Coffee coffee);
    void deleteCoffee(int id);
    List<Coffee> getCoffeesByRoasterID(int roasterID);
    List<Coffee> getCoffeesByType(String type);
}
