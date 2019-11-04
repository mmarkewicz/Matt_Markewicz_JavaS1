//package com.company.RESTWebServiceGroupProject.controller;
//
//import com.company.RESTWebServiceGroupProject.dto.Customer;
//import com.company.RESTWebServiceGroupProject.dto.Invoice;
//import com.company.RESTWebServiceGroupProject.dto.Item;
//import com.company.RESTWebServiceGroupProject.service.ServiceLayer;
//import com.company.RESTWebServiceGroupProject.viewModels.CustomerViewModel;
//import com.company.RESTWebServiceGroupProject.viewModels.InvoiceViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class Controller {
//
//    @Autowired
//    ServiceLayer serviceLayer;
//
//    // customer CRUD
//    @RequestMapping(value = "/customers", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<CustomerViewModel> getAllCustomers() {
//        return serviceLayer.findAllCustomers();
//    }
//
//    @RequestMapping(value = "/customers", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public CustomerViewModel postCustomer(@RequestBody Customer customer) {
//        return serviceLayer.saveCustomer(customer);
//    }
//
//    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void updateCustomer(@RequestBody Customer customer) {
//        serviceLayer.updateCustomer(customer);
//    }
//
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void deleteCustomer(@PathVariable int id) {
//        serviceLayer.removeCustomer(id);
//    }
//
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public CustomerViewModel getCustomer(@PathVariable int id) {
//        return serviceLayer.findCustomer(id);
//    }
//
//    // items CRUD
//    @RequestMapping(value = "/items", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Item> getAllItems() {
//        return serviceLayer.findAllItems();
//    }
//
//    @RequestMapping(value = "/items", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Item postItem(@RequestBody Item item) {
//        return serviceLayer.saveItem(item);
//    }
//
//    @RequestMapping(value = "/items", method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void putItem(@RequestBody Item item) {
//        serviceLayer.updateItem(item);
//    }
//
//    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Item getItem(@PathVariable int id) {
//        return serviceLayer.findItem(id);
//    }
//
//    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void deleteItem(@PathVariable int id) {
//        serviceLayer.removeItem(id);
//    }
//
//    @RequestMapping(value = "/invoices", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public InvoiceViewModel postInvoice(@RequestBody InvoiceViewModel invoiceViewModel) {
//        return serviceLayer.saveInvoice(invoiceViewModel);
//    }
//
//    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.NO_CONTENT)
//    public void deleteInvoice(@PathVariable int id) {
//        serviceLayer.removeInvoice(id);
//    }
//
//}
