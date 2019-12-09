package com.company.petsheltercrudservice.service;

import com.company.petsheltercrudservice.model.Pet;
import com.company.petsheltercrudservice.repository.PetShelterCrudRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PetShelterCrudServiceTest {

    PetShelterCrudService service;

    @Mock
    PetShelterCrudRepository repository;

    @Before
    public void setUp() {
        setUpMocks();
        service = new PetShelterCrudService(repository);
    }

    @Test
    public void shouldReturnPetWithIdFromCreatePet() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        Pet petWithoutId = new Pet();
        petWithoutId.setName("Test Name");
        petWithoutId.setOwner("Test Owner");
        petWithoutId.setType("Test Type");

        assertEquals(pet.toString(), service.createPet(petWithoutId).toString());
    }

    @Test
    public void shouldReturnPetListFromReadAllPets() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet);

        assertEquals(petList.toString(), service.readAllPets().toString());
    }

    @Test
    public void shouldReturnPetListFromReadPetsByOwner() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet);

        assertEquals(petList.toString(), service.readPetsByOwner("Test Owner").toString());
    }

    @Test
    public void shouldReturnPetFromReadPetById() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        assertEquals(pet.toString(), service.readPetById(1).toString());
    }

    private void setUpMocks() {
        Pet petWithoutId = new Pet();
        petWithoutId.setName("Test Name");
        petWithoutId.setOwner("Test Owner");
        petWithoutId.setType("Test Type");

        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet);

        doReturn(pet).when(repository).save(any(Pet.class));
        doReturn(petList).when(repository).findAll();
        doReturn(petList).when(repository).findPetsByOwner(anyString());
        doReturn(pet).when(repository).getOne(anyInt());
    }
}
