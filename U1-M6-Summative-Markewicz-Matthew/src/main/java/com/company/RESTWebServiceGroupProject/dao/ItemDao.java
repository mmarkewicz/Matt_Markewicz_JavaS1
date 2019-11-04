package com.company.RESTWebServiceGroupProject.dao;

import com.company.RESTWebServiceGroupProject.dto.Item;

import java.util.List;

public interface ItemDao {
    Item addItem(Item item);
    Item getItem(int id);
    List<Item> getAllItems();
    void updateItem(Item item);
    void deleteItem(int id);
}
