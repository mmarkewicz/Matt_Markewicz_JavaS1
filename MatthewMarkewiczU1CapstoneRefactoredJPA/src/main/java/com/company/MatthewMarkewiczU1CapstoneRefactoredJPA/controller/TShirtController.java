package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.controller;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.TShirt;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service.TShirtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TShirtController {

    @Autowired
    TShirtService tShirtService;

    @GetMapping(value = "/tshirts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTShirts() throws Exception {
        return tShirtService.findAllTShirts();
    }

    @GetMapping(value = "/tshirts/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt getTShirtById(@PathVariable int id) throws Exception {
        return tShirtService.findTShirtById(id);
    }

    @GetMapping(value = "/tshirts/size/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getTShirtsBySize(@PathVariable String size) throws Exception {
        return tShirtService.findTShirtsBySize(size);
    }

    @GetMapping(value = "/tshirts/color/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getTShirtsByColor(@PathVariable String color) throws Exception {
        return tShirtService.findTShirtsByColor(color);
    }

    @PostMapping(value = "/tshirts")
    @ResponseStatus(value = HttpStatus.CREATED)
    public TShirt postTShirt(@RequestBody TShirt tShirt) throws Exception {
        return tShirtService.saveTShirt(tShirt);
    }

    @PutMapping(value = "/tshirts")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateTShirt(@RequestBody TShirt tShirt) {
        tShirtService.updateTShirt(tShirt);
    }

    @DeleteMapping(value = "/tshirts/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) {
        tShirtService.deleteTShirt(id);
    }
}
