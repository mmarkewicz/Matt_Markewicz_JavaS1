package com.company;

public class Home {
    private Patio patio = new Patio();
    private Kitchen kitchen = new Kitchen();
    private Bathroom bathroom = new Bathroom();
    private Basement basement = new Basement();
    private Dimensions dimensions = new Dimensions();

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public void setBathroom(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    public Basement getBasement() {
        return basement;
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
