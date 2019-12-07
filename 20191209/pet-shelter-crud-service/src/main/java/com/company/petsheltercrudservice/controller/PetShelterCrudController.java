package com.company.petsheltercrudservice.controller;

import com.company.petsheltercrudservice.model.Pet;
import com.company.petsheltercrudservice.service.PetShelterCrudServiceServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetShelterCrudController {

    @Autowired
    PetShelterCrudServiceServiceLayer service;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return service.findAllPets();
    }
}
