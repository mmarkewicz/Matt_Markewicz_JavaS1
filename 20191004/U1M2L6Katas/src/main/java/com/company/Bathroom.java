package com.company;

public class Bathroom {
    private String flooringType;
    private boolean hasToilet;
    private boolean hasShower;
    private Dimensions dimensions = new Dimensions();

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public boolean isHasToilet() {
        return hasToilet;
    }

    public void setHasToilet(boolean hasToilet) {
        this.hasToilet = hasToilet;
    }

    public boolean isHasShower() {
        return hasShower;
    }

    public void setHasShower(boolean hasShower) {
        this.hasShower = hasShower;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
