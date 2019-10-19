package com.company.citylist.controller;

import com.company.citylist.model.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CityListController.class)
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private List<City> cityList;

    @Before
    public void setUp() throws Exception {
        cityList = new ArrayList<>();
        City cityOne = new City("Boston", "MA", 3000000, true);
        City cityTwo = new City("New York", "NY", 10000000, false);
        City cityThree = new City("Albany", "NY", 1000000, true);
        City cityFour = new City("Jersey City", "NJ", 1000000, false);
        City cityFive = new City("Trenton", "NJ", 800000, true);
        cityOne.setId(1);
        cityTwo.setId(2);
        cityThree.setId(3);
        cityFour.setId(4);
        cityFive.setId(5);
        cityList.add(cityOne);
        cityList.add(cityTwo);
        cityList.add(cityThree);
        cityList.add(cityFour);
        cityList.add(cityFive);
    }

    // GET /cities
    @Test
    public void shouldReturnAllCitiesFromList() throws Exception {
        // ARRANGE
        // convert Java object to JSON
        String outputJSON = mapper.writeValueAsString(cityList);

        // ACT & ASSERT
        mockMvc.perform(get("/cities"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJSON));
    }

    // POST /cities
    @Test
    public void shouldAddCityToList() throws Exception {
        City cityInput = new City();
        cityInput.setId(6);
        cityInput.setName("Jackson Hole");
        cityInput.setState("WY");
        cityInput.setPopulation(100000);
        cityInput.setCapital(false);
        String inputJSON = mapper.writeValueAsString(cityInput);

        City cityOutput = new City();
        cityOutput.setId(6);
        cityOutput.setName("Jackson Hole");
        cityOutput.setState("WY");
        cityOutput.setPopulation(100000);
        cityOutput.setCapital(false);
        String outputJSON = mapper.writeValueAsString(cityOutput);

        mockMvc.perform(post("/cities").content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    // GET /cities/{city}
    @Test
    public void shouldReturnCityByName() throws Exception {
        String outputJSON = mapper.writeValueAsString(cityList.get(0));

        mockMvc.perform(get("/cities/Boston"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJSON));
    }

    // DELETE /cities/{city}
    @Test
    public void shouldDeleteCityByName() throws Exception {
        String outputJSON = mapper.writeValueAsString(cityList.remove(2));

        mockMvc.perform(delete("/cities/Albany"))
                .andExpect(status().isNoContent())
                .andExpect(content().json(outputJSON));
    }

}
