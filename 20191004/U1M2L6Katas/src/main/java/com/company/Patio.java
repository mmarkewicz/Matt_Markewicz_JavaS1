package com.company;

public class Patio {
    private String material;
    private String color;
    private boolean hasGrill;
    private Dimensions dimensions = new Dimensions();

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHasGrill() {
        return hasGrill;
    }

    public void setHasGrill(boolean hasGrill) {
        this.hasGrill = hasGrill;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
}
