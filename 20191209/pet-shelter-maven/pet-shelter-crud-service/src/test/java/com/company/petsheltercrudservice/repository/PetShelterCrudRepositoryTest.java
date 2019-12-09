package com.company.petsheltercrudservice.repository;

import com.company.petsheltercrudservice.model.Pet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void shouldAddGetDelete() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        pet = repository.save(pet);

        assertEquals(pet.toString(), repository.getOne(pet.getId()).toString());

        repository.deleteById(pet.getId());

        assertEquals(repository.findAll().size(), 0);
    }

    @Test
    public void shouldGetAll() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        repository.save(pet);

        assertEquals(repository.findAll().size(), 1);
    }

    @Test
    public void shouldUpdate() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        pet = repository.save(pet);

        pet.setName("New Test Name");
        repository.save(pet);

        assertEquals("New Test Name", repository.getOne(pet.getId()).getName());
    }

    @Test
    public void shouldReturnPetsByOwner() {
        Pet pet = new Pet();
        pet.setType("Test Type");
        pet.setOwner("Test Owner");
        pet.setName("Test Name");
        pet = repository.save(pet);

        assertEquals(pet.toString(), repository.findPetsByOwner("Test Owner").get(0).toString());
    }
}
