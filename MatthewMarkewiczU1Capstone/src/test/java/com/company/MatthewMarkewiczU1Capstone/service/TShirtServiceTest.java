package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.TShirtDao;
import com.company.MatthewMarkewiczU1Capstone.dto.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class TShirtServiceTest {

    TShirtService tShirtService;

    @Mock
    TShirtDao tShirtDao;

    @Before
    public void setUp() {
        setUpTShirtMocks();

        tShirtService = new TShirtService(tShirtDao);
    }

    @Test
    public void shouldReturnTShirtFromDbById() {
        TShirt tshirtFromDb = new TShirt();
        tshirtFromDb.setColor("Black");
        tshirtFromDb.setPrice(new BigDecimal(9.99));
        tshirtFromDb.setDescription("A black tee");
        tshirtFromDb.setQuantity(10);
        tshirtFromDb.setSize("M");
        tshirtFromDb.setTShirtId(93);

        assertEquals(tshirtFromDb, tShirtService.findTShirtById(93));
    }

    @Test
    public void shouldReturnListOfAllTShirts() {
        TShirt tshirtFromDb = new TShirt();
        tshirtFromDb.setColor("Black");
        tshirtFromDb.setPrice(new BigDecimal(9.99));
        tshirtFromDb.setDescription("A black tee");
        tshirtFromDb.setQuantity(10);
        tshirtFromDb.setSize("M");
        tshirtFromDb.setTShirtId(93);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tshirtFromDb);

        assertEquals(tShirtList, tShirtService.findAllTShirts());
    }

    @Test
    public void shouldReturnListOfTShirtsByColor() {
        TShirt tshirtFromDb = new TShirt();
        tshirtFromDb.setColor("Black");
        tshirtFromDb.setPrice(new BigDecimal(9.99));
        tshirtFromDb.setDescription("A black tee");
        tshirtFromDb.setQuantity(10);
        tshirtFromDb.setSize("M");
        tshirtFromDb.setTShirtId(93);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tshirtFromDb);

        assertEquals(tShirtList, tShirtService.findTShirtsByColor("Black"));
    }

    @Test
    public void shouldReturnListOfTShirtsBySize() {
        TShirt tshirtFromDb = new TShirt();
        tshirtFromDb.setColor("Black");
        tshirtFromDb.setPrice(new BigDecimal(9.99));
        tshirtFromDb.setDescription("A black tee");
        tshirtFromDb.setQuantity(10);
        tshirtFromDb.setSize("M");
        tshirtFromDb.setTShirtId(93);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tshirtFromDb);

        assertEquals(tShirtList, tShirtService.findTShirtsBySize("M"));
    }

    @Test
    public void shouldAddTShirtFromServiceLayer() {
        TShirt tshirt = new TShirt();
        tshirt.setColor("Black");
        tshirt.setPrice(new BigDecimal(9.99));
        tshirt.setDescription("A black tee");
        tshirt.setQuantity(10);
        tshirt.setSize("M");

        TShirt tshirtFromDb = new TShirt();
        tshirtFromDb.setColor("Black");
        tshirtFromDb.setPrice(new BigDecimal(9.99));
        tshirtFromDb.setDescription("A black tee");
        tshirtFromDb.setQuantity(10);
        tshirtFromDb.setSize("M");
        tshirtFromDb.setTShirtId(93);

        assertEquals(tshirtFromDb, tShirtService.saveTShirt(tshirt));
    }

    @Test
    public void shouldReturnNullWhenInvalidId() {
        assertNull(tShirtService.findTShirtById(100000));
    }

    @Test
    public void shouldReturnEmptyTShirtList() {
        List<TShirt> tShirtList = new ArrayList<>();
        assertEquals(tShirtList, tShirtService.findTShirtsBySize("None"));
        assertEquals(tShirtList, tShirtService.findTShirtsByColor("Eleven"));
    }

    public void setUpTShirtMocks() {
        TShirt tshirt = new TShirt();
        tshirt.setColor("Black");
        tshirt.setPrice(new BigDecimal(9.99));
        tshirt.setDescription("A black tee");
        tshirt.setQuantity(10);
        tshirt.setSize("M");

        TShirt tshirtFromDb = new TShirt();
        tshirtFromDb.setColor("Black");
        tshirtFromDb.setPrice(new BigDecimal(9.99));
        tshirtFromDb.setDescription("A black tee");
        tshirtFromDb.setQuantity(10);
        tshirtFromDb.setSize("M");
        tshirtFromDb.setTShirtId(93);

        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList.add(tshirtFromDb);

        doReturn(tshirtFromDb).when(tShirtDao).getTShirt(93);
        doReturn(tShirtList).when(tShirtDao).getAllTShirts();
        doReturn(tShirtList).when(tShirtDao).getTShirtsByColor("Black");
        doReturn(tShirtList).when(tShirtDao).getTShirtsBySize("M");
        doReturn(tshirtFromDb).when(tShirtDao).addTShirt(tshirt);
    }
}

//         TShirt tshirt = new TShirt();
//        tshirt.setColor("Black");
//        tshirt.setPrice(new BigDecimal(9.99));
//        tshirt.setDescription("A black tee");
//        tshirt.setQuantity(10);
//        tshirt.setSize("M");