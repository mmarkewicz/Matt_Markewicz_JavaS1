package com.company.MatthewMarkewiczU1Capstone.exceptions;

public class InvalidStateCodeException extends RuntimeException {

    public InvalidStateCodeException() {
        super("Please enter a valid state code");
    }
}
