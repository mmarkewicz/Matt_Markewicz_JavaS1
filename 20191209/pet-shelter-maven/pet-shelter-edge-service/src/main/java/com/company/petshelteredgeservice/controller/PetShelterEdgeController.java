package com.company.petshelteredgeservice.controller;

import com.company.petshelteredgeservice.model.Pet;
import com.company.petshelteredgeservice.service.PetShelterEdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetShelterEdgeController {

    @Autowired
    PetShelterEdgeService service;

    @GetMapping("/pet/{id}")
    public Pet getPetById(@PathVariable int id) {
        return service.findPetById(id);
    }

    @PutMapping("/pets")
    public String putPetOwner(@RequestBody Pet pet) {
        return service.updateOwner(pet);
    }
}
