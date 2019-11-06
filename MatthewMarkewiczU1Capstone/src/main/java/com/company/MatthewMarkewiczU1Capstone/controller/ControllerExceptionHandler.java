package com.company.MatthewMarkewiczU1Capstone.controller;

import com.company.MatthewMarkewiczU1Capstone.exceptions.InvalidStateCodeException;
import com.company.MatthewMarkewiczU1Capstone.exceptions.QuantityGreaterThanInventoryException;
import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {QuantityGreaterThanInventoryException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> quantityGreaterThanInventoryException(QuantityGreaterThanInventoryException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {InvalidStateCodeException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> invalidStateCodeException(InvalidStateCodeException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
}