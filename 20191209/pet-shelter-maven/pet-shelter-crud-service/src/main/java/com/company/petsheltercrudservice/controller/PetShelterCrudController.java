package com.company.petsheltercrudservice.controller;

import com.company.petsheltercrudservice.model.Pet;
import com.company.petsheltercrudservice.service.PetShelterCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetShelterCrudController {

    @Autowired
    PetShelterCrudService service;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return service.readAllPets();
    }

    @GetMapping("/pet/{id}")
    public Pet getPetById(@PathVariable int id) {
        return service.readPetById(id);
    }

    @GetMapping("/pets/{owner}")
    public List<Pet> getPetsByOwner(@PathVariable String owner) { return service.readPetsByOwner(owner); }

    @PostMapping("/pets")
    public Pet postPet(@RequestBody Pet pet) {
        return service.createPet(pet);
    }

    @PutMapping("/pets")
    public void updatePet(@RequestBody Pet pet) {
        service.updatePet(pet);
    }

    @DeleteMapping("/pet/{id}")
    public void deletePet(@PathVariable int id) {
        service.deletePet(id);
    }
}
