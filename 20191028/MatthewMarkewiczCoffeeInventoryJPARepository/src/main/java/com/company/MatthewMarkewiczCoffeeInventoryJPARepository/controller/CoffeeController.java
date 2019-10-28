package com.company.MatthewMarkewiczCoffeeInventoryJPARepository.controller;

import com.company.MatthewMarkewiczCoffeeInventoryJPARepository.dao.CoffeeDAO;
import com.company.MatthewMarkewiczCoffeeInventoryJPARepository.dto.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CoffeeController {

    @Autowired
    private CoffeeDAO coffeeDAO;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Coffee> getCoffeeById(@PathVariable int id) {
        return coffeeDAO.findById(id);
    }

}
