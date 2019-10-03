package com.company;

public class Kitchen {
    private String flooringType;
    private boolean hasFridge;
    private boolean hasDishwasher;
    private boolean hasOven;
    private Dimensions dimensions = new Dimensions();

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

    public boolean isHasDishwasher() {
        return hasDishwasher;
    }

    public void setHasDishwasher(boolean hasDishwasher) {
        this.hasDishwasher = hasDishwasher;
    }

    public boolean isHasOven() {
        return hasOven;
    }

    public void setHasOven(boolean hasOven) {
        this.hasOven = hasOven;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
