package com.company.petsheltercrudservice.service;

import com.company.petsheltercrudservice.model.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PetShelterCrudServiceTest {

    @Autowired
    PetShelterCrudService service;

    @Before
    public void setUp() {
        service.findAllPets().forEach(pet -> service.deletePetById(pet.getId()));
    }

    @After
    public void tearDown() {
        service.findAllPets().forEach(pet -> service.deletePetById(pet.getId()));
    }

    @Test
    public void shouldAddGetDeletePet() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        pet = service.createPet(pet);

        assertEquals(pet.toString(), service.findPetById(pet.getId()).toString());

    }
}
