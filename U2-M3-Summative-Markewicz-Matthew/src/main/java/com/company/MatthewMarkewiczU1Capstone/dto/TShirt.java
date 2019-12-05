package com.company.MatthewMarkewiczU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {
    private int tShirtId;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private int quantity;

    public int getTShirtId() {
        return tShirtId;
    }

    public void setTShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TShirt)) return false;
        TShirt tShirt = (TShirt) o;
        return tShirtId == tShirt.tShirtId &&
                quantity == tShirt.quantity &&
                Objects.equals(size, tShirt.size) &&
                Objects.equals(color, tShirt.color) &&
                Objects.equals(description, tShirt.description) &&
                Objects.equals(price, tShirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "tShirtId=" + tShirtId +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

// t_shirt_id int(11) not null auto_increment primary key,
//    size varchar(20) not null,
//    color varchar(20) not null,
//    description varchar(255) not null,
//    price decimal(5,2) not null,
//    quantity int(11) not null