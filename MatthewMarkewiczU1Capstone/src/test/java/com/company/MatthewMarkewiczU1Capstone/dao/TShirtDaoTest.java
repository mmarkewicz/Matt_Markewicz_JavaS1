package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.TShirt;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TShirtDaoTest {

    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() {
        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        tShirtList.stream()
                .forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getTShirtId()));
    }

    @After
    public void tearDown() {
        List<TShirt> tShirtList = tShirtDao.getAllTShirts();
        tShirtList.stream()
                .forEach(tShirt -> tShirtDao.deleteTShirt(tShirt.getTShirtId()));
    }

    @Test
    public void getAddDeleteTShirts() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setQuantity(10);
        tShirt.setPrice(new BigDecimal(15.00));
        tShirt.setDescription("Testing Testing");
        tShirt.setColor("Black");
        tShirt = tShirtDao.addTShirt(tShirt);
        tShirt.setPrice(tShirt.getPrice().setScale(2, RoundingMode.HALF_EVEN));

        TShirt testTShirt = tShirtDao.getTShirt(tShirt.getTShirtId());
        assertEquals(tShirt, testTShirt);

        tShirtDao.deleteTShirt(tShirt.getTShirtId());
        assertEquals(tShirtDao.getAllTShirts().size(), 0);
    }

    @Test
    public void getAllTShirts() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setQuantity(10);
        tShirt.setPrice(new BigDecimal(15.00));
        tShirt.setDescription("Testing Testing");
        tShirt.setColor("Black");
        tShirtDao.addTShirt(tShirt);

        assertEquals(tShirtDao.getAllTShirts().size(), 1);
    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setQuantity(10);
        tShirt.setPrice(new BigDecimal(15.00));
        tShirt.setDescription("Testing Testing");
        tShirt.setColor("Black");
        tShirt = tShirtDao.addTShirt(tShirt);

        tShirt.setColor("Blue");
        tShirtDao.updateTShirt(tShirt);

        assertEquals(tShirtDao.getTShirt(tShirt.getTShirtId()).getColor(), "Blue");
    }

    @Test
    public void getTShirtBySize() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setQuantity(10);
        tShirt.setPrice(new BigDecimal(15.00));
        tShirt.setDescription("Testing Testing");
        tShirt.setColor("Black");
        tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getTShirtsBySize("M");

        assertEquals(tShirtList.get(0).getSize(), "M");
    }

    @Test
    public void getTShirtByColor() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setQuantity(10);
        tShirt.setPrice(new BigDecimal(15.00));
        tShirt.setDescription("Testing Testing");
        tShirt.setColor("Black");
        tShirtDao.addTShirt(tShirt);

        List<TShirt> tShirtList = tShirtDao.getTShirtsByColor("Black");

        assertEquals(tShirtList.get(0).getColor(), "Black");
    }
}
