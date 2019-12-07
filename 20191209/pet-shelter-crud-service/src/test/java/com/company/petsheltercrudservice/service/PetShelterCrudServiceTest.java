package com.company.petsheltercrudservice.service;

import com.company.petsheltercrudservice.model.Pet;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PetShelterCrudServiceTest {

    @Autowired
    PetShelterCrudService service;

    @BeforeEach
    public void setUp() {
        List<Pet> petList = service.findAllPets();
        petList.forEach(pet -> service.deletePetById(pet.getId()));
    }

    @After
    public void tearDown() {
        List<Pet> petList = service.findAllPets();
        petList.forEach(pet -> service.deletePetById(pet.getId()));
    }

    @Test
    public void shouldAddGetDeletePet() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        pet = service.createPet(pet);

        assertEquals(pet.toString(), service.findPetById(pet.getId()).toString());

        service.deletePetById(pet.getId());

        assertEquals(service.findAllPets().size(), 0);
    }

    @Test
    public void shouldGetAllPets() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        service.createPet(pet);

        assertEquals(service.findAllPets().size(), 1);
    }

    @Test
    public void shouldUpdatePet() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        pet = service.createPet(pet);

        pet.setType("New Test Type");
        service.updatePet(pet);

        assertEquals(service.findPetById(pet.getId()).getType(), "New Test Type");
    }
}
