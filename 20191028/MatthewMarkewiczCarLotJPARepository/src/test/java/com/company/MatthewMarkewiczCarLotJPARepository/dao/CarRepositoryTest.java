package com.company.MatthewMarkewiczCarLotJPARepository.dao;

import com.company.MatthewMarkewiczCarLotJPARepository.dto.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;

    @Before
    public void setUp() throws Exception {
        List<Car> carList = carRepository.findAll();
        for (Car c : carList) {
            carRepository.delete(c);
        }
    }

    @Test
    public void addGetDeleteCar() {
        Car car = new Car();
        car.setMake("Lamborghini");
        car.setModel("Urus");
        car.setColor("White");
        car.setYear("2019");

        // add
        carRepository.save(car);

        // get
        List<Car> carRef = carRepository.findByMake("Lamborghini");

        // delete
        carRepository.delete(car);

        assertEquals(carRepository.findAll().size(), 0);
        assertEquals(carRef.size(), 1);
    }
}
