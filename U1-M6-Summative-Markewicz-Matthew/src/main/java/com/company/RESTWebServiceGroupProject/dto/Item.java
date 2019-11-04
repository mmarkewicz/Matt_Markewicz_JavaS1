package com.company.RESTWebServiceGroupProject.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Item {

    private Integer itemId;

    @NotEmpty(message = "Please enter a valid name.")
    private String name;

    private String description;

    @DecimalMin(value = "0.00", inclusive = true, message = "Please enter a valid daily rate.")
    @Digits(integer = 7, fraction = 2, message = "Please enter a valid daily rate.")
    private BigDecimal dailyRate;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(dailyRate, item.dailyRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, name, description, dailyRate);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dailyRate=" + dailyRate +
                '}';
    }
}
