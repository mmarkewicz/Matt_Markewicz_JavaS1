package com.company.RESTWebServiceGroupProject.dao;

import com.company.RESTWebServiceGroupProject.dto.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemDaoTest {

    @Autowired
    ItemDao itemDao;

    @Before
    public void setUp() throws Exception {
        List<Item> itemList = itemDao.getAllItems();
        itemList.stream()
                .forEach(item -> itemDao.deleteItem(item.getItemId()));
    }

    @After
    public void tearDown() {
        List<Item> itemList = itemDao.getAllItems();
        itemList.stream()
                .forEach(item -> itemDao.deleteItem(item.getItemId()));
    }

    @Test
    public void addGetDeleteItem() {

        Item item = new Item();
        item.setName("Item");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("9.99"));
        item = itemDao.addItem(item);

        Item item1 = itemDao.getItem(item.getItemId());
        assertEquals(item, item1);

        itemDao.deleteItem(item.getItemId());
        item1 = itemDao.getItem(item.getItemId());
        assertNull(item1);
    }

    @Test
    public void getAllItems() {

        Item item = new Item();
        item.setName("Item");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("9.99"));
        itemDao.addItem(item);

        item = new Item();
        item.setName("Item 2");
        item.setDescription("Item Description 2");
        item.setDailyRate(new BigDecimal("25.49"));
        itemDao.addItem(item);

        List<Item> itemList = itemDao.getAllItems();
        assertEquals(2, itemList.size());
    }

    @Test
    public void updateItem() {

        Item item = new Item();
        item.setName("Item");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("9.99"));
        item = itemDao.addItem(item);

        item.setName("UPDATED ITEM NAME");
        item.setDescription("UPDATE ITEM DESCRIPTION");
        item.setDailyRate(new BigDecimal("0.99"));
        itemDao.updateItem(item);

        Item item1 = itemDao.getItem(item.getItemId());
        assertEquals(item, item1);
    }
}