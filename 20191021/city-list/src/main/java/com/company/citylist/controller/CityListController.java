package com.company.citylist.controller;

import com.company.citylist.model.City;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CityListController {

    private List<City> cityList = new ArrayList<>();

    public CityListController() {
        cityList.add(new City("Boston", "MA", 3000000, true));
        cityList.add(new City("New York", "NY", 10000000, false));
        cityList.add(new City("Albany", "NY", 1000000, true));
        cityList.add(new City("Jersey City", "NJ", 1000000, false));
        cityList.add(new City("Trenton", "NJ", 800000, true));
    }

    @RequestMapping(path = "/cities", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<City> getAllCities() {
        return cityList;
    }

    @RequestMapping(path = "/cities", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public City addNewCity(@RequestBody @Valid City city) {
        cityList.add(city);
        return city;
    }

    @RequestMapping(path = "/cities/{cityName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public City getCityByName(@PathVariable String cityName) {
        City responseCity = null;
        for (City city : cityList) {
            if (city.getName().equals(cityName)) {
                responseCity = city;
                break;
            }
        }
        return responseCity;
    }

    @RequestMapping(path = "/cities/{cityName}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<City> deleteCityByName(@PathVariable String cityName) {
        int indexOfCityToBeDeleted = -1;
        for (City city : cityList) {
            if (city.getName().equals(cityName)) {
                indexOfCityToBeDeleted = cityList.indexOf(city);
                break;
            }
        }
        cityList.remove(indexOfCityToBeDeleted);
        return cityList;
    }
}