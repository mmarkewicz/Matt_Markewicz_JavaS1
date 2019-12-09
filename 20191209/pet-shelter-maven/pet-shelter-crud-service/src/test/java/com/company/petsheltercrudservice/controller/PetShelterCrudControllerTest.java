package com.company.petsheltercrudservice.controller;

import com.company.petsheltercrudservice.model.Pet;
import com.company.petsheltercrudservice.repository.PetShelterCrudRepository;
import com.company.petsheltercrudservice.service.PetShelterCrudService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(PetShelterCrudController.class)
public class PetShelterCrudControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PetShelterCrudRepository repository;

    @MockBean
    PetShelterCrudService service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnListOfPetsFromGetAllPets() throws Exception {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet);

        when(service.readAllPets()).thenReturn(petList);

        this.mockMvc.perform(get("/pets"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Name")));
    }

    @Test
    public void shouldReturnListOfPetsFromGetPetsByOwner() throws Exception {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet);

        when(service.readPetsByOwner(anyString())).thenReturn(petList);

        this.mockMvc.perform(get("/pets/Test Owner"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Name")));
    }

    @Test
    public void shouldReturnPetFromGetPetById() throws Exception {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        when(service.readPetById(anyInt())).thenReturn(pet);

        this.mockMvc.perform(get("/pet/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Name")));
    }

    @Test
    public void shouldReturnPetFromPostPet() throws Exception {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        Pet petWithoutId = new Pet();
        pet.setName("Test Name");
        pet.setOwner("Test Owner");
        pet.setType("Test Type");

        when(service.createPet(any(Pet.class))).thenReturn(pet);

        String json = mapper.writeValueAsString(petWithoutId);

        this.mockMvc.perform(post("/pets")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Name")));
    }

}
