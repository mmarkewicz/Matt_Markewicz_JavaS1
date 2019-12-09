package com.company.petsheltercrudservice.service;

import com.company.petsheltercrudservice.model.Pet;
import com.company.petsheltercrudservice.repository.PetShelterCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetShelterCrudService {

    PetShelterCrudRepository repository;

    public PetShelterCrudService(PetShelterCrudRepository repository) {
        this.repository = repository;
    }

    public PetShelterCrudService() {}

    public Pet createPet(Pet pet) {
        return repository.save(pet);
    }

    public List<Pet> readAllPets() {
        return repository.findAll();
    }

    public Pet readPetById(int id) {
        return repository.getOne(id);
    }

    public List<Pet> readPetsByOwner(String owner) {
        return repository.findPetsByOwner(owner);
    }

    public void updatePet(Pet pet) {
        repository.save(pet);
    }

    public void deletePet(int id) {
        repository.deleteById(id);
    }

}
