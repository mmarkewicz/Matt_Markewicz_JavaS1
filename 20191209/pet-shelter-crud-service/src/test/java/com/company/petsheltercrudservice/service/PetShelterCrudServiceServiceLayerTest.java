package com.company.petsheltercrudservice.service;

import com.company.petsheltercrudservice.model.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PetShelterCrudServiceServiceLayerTest {

    @Autowired
    PetShelterCrudServiceServiceLayer service;

    @Before
    public void setUp() {
        List<Pet> petList = service.findAllPets();
        petList.forEach(pet -> service.deletePet(pet.getId()));
    }

    @After
    public void tearDown() {
        List<Pet> petList = service.findAllPets();
        petList.forEach(pet -> service.deletePet(pet.getId()));
    }

    @Test
    public void addGetDeletePet() {
        Pet pet = new Pet();
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");
        pet = service.addPet(pet);

        assertEquals(pet.toString(), service.findPetById(pet.getId()));

    }
}
