package com.company;

public class Kitchen {

    private float squareFootage;
    private float width;
    private float length;
    private String flooringType;
    private boolean hasFridge;
    private boolean hasStove;

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

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public boolean isHasFridge() {
        return hasFridge;
    }

    public void setHasFridge(boolean hasFridge) {
        this.hasFridge = hasFridge;
    }

    public boolean isHasStove() {
        return hasStove;
    }

    public void setHasStove(boolean hasStove) {
        this.hasStove = hasStove;
    }
}
