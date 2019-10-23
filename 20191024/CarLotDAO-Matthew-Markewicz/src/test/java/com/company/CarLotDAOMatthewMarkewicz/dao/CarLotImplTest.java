package com.company.CarLotDAOMatthewMarkewicz.dao;

import com.company.CarLotDAOMatthewMarkewicz.model.Car;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarLotImplTest {

    @Autowired
    protected CarLotDAO dao;

    Car testCar = new Car();

    @Before
    void setUp() throws Exception {
        List<Car> cList = dao.getAllCars();

        cList.stream()
                .forEach(car -> dao.deleteCar(car.getId()));

        testCar.setMake("Honda");
        testCar.setModel("Civic");
        testCar.setColor("Red");
        testCar.setYear("1999");

        dao.addCar(testCar);
    }

    @Test
    void getCar() {
        Car resultCar = dao.getCar(1);
        testCar.setId(1);
        assertEquals(resultCar, testCar);
    }

    @Test
    void getAllCars() {
        List<Car> testList = new ArrayList<>();
        testCar.setId(1);
        testList.add(testCar);
        List<Car> listFromDB = dao.getAllCars();
        assertEquals(listFromDB.size(), 2);
    }

    @Test
    void addCar() {
        dao.addCar(testCar);
        assertEquals(dao.getAllCars().size(), 2);
    }

    @Test
    void updateCar() {
        testCar.setYear("2009");
        dao.updateCar(testCar);
        assertEquals(dao.getCar(1).getYear(), "2009");
    }

    @Test
    void deleteCar() {
        dao.deleteCar(1);
        assertEquals(dao.getAllCars().size(), 0);
    }

    @Test
    void getCarsByMake() {
        int listSize = dao.getCarsByMake("Honda").size();
        assertEquals(listSize, 1);
    }

    @Test
    void getCarsByColor() {
        int listSize = dao.getCarsByColor("Black").size();
        assertEquals(listSize, 0);
    }
}