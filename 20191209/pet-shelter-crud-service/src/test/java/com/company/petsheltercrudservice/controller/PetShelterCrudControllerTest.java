package com.company.petsheltercrudservice.controller;

import com.company.petsheltercrudservice.model.Pet;
import com.company.petsheltercrudservice.service.PetShelterCrudService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PetShelterCrudController.class)
@RunWith(MockitoJUnitRunner.class)
public class PetShelterCrudControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PetShelterCrudService service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnPetListFromGetAllPets() throws Exception {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setType("Test Type");
        pet.setName("Test Name");
        pet.setOwner("Test Owner");

        List<Pet> petList = new ArrayList<>();
        petList.add(pet);

        when(service.findAllPets()).thenReturn(petList);

        this.mockMvc.perform(get("/pets"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Type")))
                .andExpect(content().string(containsString("Test Name")))
                .andExpect(content().string(containsString("Test Owner")));
    }

}
