package com.company.petsheltercrudservice.service;

import com.company.petsheltercrudservice.model.Pet;
import com.company.petsheltercrudservice.repository.PetShelterCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetShelterCrudService {

    @Autowired
    PetShelterCrudRepository repository;

    public Pet createPet(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> findAllPets() {
        return repository.findAll();
    }

    public Pet findPetById(int id) {
        return repository.getOne(id);
    }

    public void updatePet(Pet pet) {
        repository.save(pet);
    }

    public void deletePetById(int id) {
        repository.deleteById(id);
    }
}
