package com.company.citylist.model;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class City {
    private static int counter = 1;
    private int id;
    @NotEmpty(message = "Field cannot be empty")
    @Size(message = "Min 2 characters", min = 2 )
    private String name;
    @NotEmpty(message = "Field cannot be empty")
    @Size(message = "Min 2 characters", min = 2 )
    private String state;
    @NonNull
    @Min(value = 0, message = "Population Have to be positive number")
    private Integer population;
    private boolean isCapital;

    public City(String name, String state, Integer population, boolean isCapital) {
        this.id = counter++;
        this.name = name;
        this.state = state;
        this.population = population;
        this.isCapital = isCapital;
    }

    public City() {
        this.id = counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

}
