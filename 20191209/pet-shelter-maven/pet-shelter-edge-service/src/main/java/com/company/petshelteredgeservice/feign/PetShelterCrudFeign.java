package com.company.petshelteredgeservice.feign;

import com.company.petshelteredgeservice.model.Pet;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "pet-shelter-crud-service")
public interface PetShelterCrudFeign {

    @GetMapping("/pets")
    List<Pet> getAllPets();

    @GetMapping("/pet/{id}")
    Pet getPetById(@PathVariable int id);

    @GetMapping("/pets/{owner}")
    List<Pet> getPetsByOwner(@PathVariable String owner);

    @PostMapping("/pets")
    Pet postPet(@RequestBody Pet pet);

    @PutMapping("/pets")
    void putPet(@RequestBody Pet pet);

    @DeleteMapping("/pet/{id}")
    void deletePet(@PathVariable int id);
}
