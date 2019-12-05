package com.company.MatthewMarkewiczU1Capstone.controller;

import com.company.MatthewMarkewiczU1Capstone.exceptions.QuantityGreaterThanInventoryException;
import com.company.MatthewMarkewiczU1Capstone.service.InvoiceService;
import com.company.MatthewMarkewiczU1Capstone.dto.Invoice;
import com.company.MatthewMarkewiczU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoice/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable int id) throws Exception {
        return invoiceService.findInvoice(id);
    }

    @PostMapping("/invoice")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice postInvoice(@RequestBody InvoiceViewModel invoiceViewModel) throws Exception {
        return invoiceService.saveInvoice(invoiceViewModel);
    }
}
