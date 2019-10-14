package com.company.spacebook.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static int counter = 0;
    private List<User> spacePals = new ArrayList<>();
    private List<SpacePost> spacePosts = new ArrayList<>();
    private String name;
    private int id = 0;

    public User (String name) {
        this.name = name;
        this.id = counter;
        counter++;
    }

    public List<User> getSpacePals() {
        return spacePals;
    }

    public void setSpacePals(List<User> spacePals) {
        this.spacePals = spacePals;
    }

    public List<SpacePost> getSpacePosts() {
        return spacePosts;
    }

    public void setSpacePosts(List<SpacePost> spacePosts) {
        this.spacePosts = spacePosts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
