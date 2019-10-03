package com.company;

public class Patio {
    private float squareFootage;
    private float length;
    private float width;
    private String flooringType;
    private boolean hasGrill;

    public float getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(float squareFootage) {
        this.squareFootage = squareFootage;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public boolean isHasGrill() {
        return hasGrill;
    }

    public void setHasGrill(boolean hasGrill) {
        this.hasGrill = hasGrill;
    }
}

