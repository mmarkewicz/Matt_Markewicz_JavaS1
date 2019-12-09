package com.company.petsheltercrudservice.repository;

import com.company.petsheltercrudservice.model.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.juniper.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PetShelterCrudRepositoryTest {

    @Autowired
    PetShelterCrudRepository repository;

    @Before
    public void setUp() {
        repository.findAll().forEach(pet -> repository.deleteById(pet.getId()));
    }

    @After
    public void tearDown() {
        repository.findAll().forEach(pet -> repository.deleteById(pet.getId()));
    }

    @Test
    public void shouldAddGetDeletePets() {
        Pet pet = new Pet();
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");
        pet = repository.save(pet);

        assertEquals(pet.toString(), repository.getOne(pet.getId()).toString());
    }

}
