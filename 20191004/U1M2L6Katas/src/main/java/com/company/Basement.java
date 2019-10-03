package com.company;

public class Basement {

    private float squareFootage;
    private float width;
    private float length;
    private Bathroom basementBathroom;
    private Room basementBedroom;

    public float getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(float squareFootage) {
        this.squareFootage = squareFootage;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public Bathroom getBasementBathroom() {
        return basementBathroom;
    }

    public void setBasementBathroom(Bathroom basementBathroom) {
        this.basementBathroom = basementBathroom;
    }

    public Room getBasementBedroom() {
        return basementBedroom;
    }

    public void setBasementBedroom(Room basementBedroom) {
        this.basementBedroom = basementBedroom;
    }
}
