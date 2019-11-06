package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.viewmodel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class InvoiceViewModel {

    @NotEmpty(message = "You must enter a valid name")
    private String name;
    @NotEmpty(message = "You must enter a valid street")
    private String street;
    @NotEmpty(message = "You must enter a valid city")
    private String city;
    @NotEmpty(message = "You must enter a valid state")
    private String state;
    @NotEmpty(message = "Zip code cannot be empty")
    @Size(min = 5, max = 5, message = "Zip must be 5 numbers long")
    private String zip;
    @NotEmpty(message = "Must provide a valid item tyoe")
    private String itemType;
    @Min(value = 1, message = "Item ID must be larger than 0")
    private int itemId;
    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
        if (!(o instanceof InvoiceViewModel)) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return itemId == that.itemId &&
                quantity == that.quantity &&
                Objects.equals(name, that.name) &&
                Objects.equals(street, that.street) &&
                Objects.equals(city, that.city) &&
                Objects.equals(state, that.state) &&
                Objects.equals(zip, that.zip) &&
                Objects.equals(itemType, that.itemType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, city, state, zip, itemType, itemId, quantity);
    }

    @Override
    public String toString() {
        return "InvoiceViewModel{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", itemType='" + itemType + '\'' +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
