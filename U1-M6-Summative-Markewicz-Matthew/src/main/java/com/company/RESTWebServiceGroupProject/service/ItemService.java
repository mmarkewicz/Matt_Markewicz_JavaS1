package com.company.RESTWebServiceGroupProject.service;

import com.company.RESTWebServiceGroupProject.dao.ItemDao;
import com.company.RESTWebServiceGroupProject.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemDao itemDao;

    public Item saveItem(Item item) {
        return itemDao.addItem(item);
    }

    public Item findItem(int id) {
        return itemDao.getItem(id);
    }

    public List<Item> findAllItems() {
        return itemDao.getAllItems();
    }

    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }

    public void removeItem(int id) {
        itemDao.deleteItem(id);
    }

}
