package com.company.MatthewMarkewiczCarLotJPARepository.controller;

import com.company.MatthewMarkewiczCarLotJPARepository.dao.CarRepository;
import com.company.MatthewMarkewiczCarLotJPARepository.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarLotController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Car createCar(@RequestBody Car car) {
        carRepository.save(car);
        return car;
    }

    @RequestMapping(value = "/getByMake/{make}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCarByMake(@PathVariable String make) {
        return carRepository.findByMake(make);
    }

    @RequestMapping(value = "/getByColor/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCarByColor(@PathVariable String color) {
        return carRepository.findByColor(color);
    }

    @RequestMapping(value = "/getByMakeAndColor/{make}/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCarByMakeAndColor(@PathVariable String make, @PathVariable String color) {
        return carRepository.findByMakeAndColor(make, color);
    }
    
}
