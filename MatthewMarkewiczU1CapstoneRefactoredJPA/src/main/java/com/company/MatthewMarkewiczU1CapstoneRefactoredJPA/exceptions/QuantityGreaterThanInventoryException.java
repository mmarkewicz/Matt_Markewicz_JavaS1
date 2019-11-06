package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.exceptions;

public class QuantityGreaterThanInventoryException extends RuntimeException {

    public QuantityGreaterThanInventoryException() {
        super("Quantity must be greater than 0 and less than the number of items in the inventory.");
    }

    public QuantityGreaterThanInventoryException(String message) {
        super(message);
    }
}
