package com.company.petshelteredgeservice.service;

import com.company.petshelteredgeservice.feign.PetShelterCrudFeign;
import com.company.petshelteredgeservice.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetShelterEdgeService {

    PetShelterCrudFeign feign;

    @Autowired
    public PetShelterEdgeService(PetShelterCrudFeign feign) {
        this.feign = feign;
    }

    public Pet findPetById(int id) {
        return feign.getPetById(id);
    }

    public String updateOwner(Pet pet) throws Exception {
        Pet returnedPet = feign.getPetById(pet.getId());
        returnedPet.setOwner(pet.getOwner());

        if (feign.getPetsByOwner(pet.getOwner()).size() > 3) {
            throw new Exception("An owner cannot have more than 3 pets!");
        } else {
            return "Successfully updated pet entry";
        }
    }

}
