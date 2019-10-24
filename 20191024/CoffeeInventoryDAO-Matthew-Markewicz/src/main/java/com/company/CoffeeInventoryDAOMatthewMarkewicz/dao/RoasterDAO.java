package com.company.CoffeeInventoryDAOMatthewMarkewicz.dao;

import com.company.CoffeeInventoryDAOMatthewMarkewicz.model.Roaster;

import java.util.List;

public interface RoasterDAO {
    Roaster getRoaster(int id);
    List<Roaster> getAllRoasters();
    Roaster addRoaster(Roaster roaster);
    void updateRoaster(Roaster roaster);
    void deleteRoaster(int id);
}
