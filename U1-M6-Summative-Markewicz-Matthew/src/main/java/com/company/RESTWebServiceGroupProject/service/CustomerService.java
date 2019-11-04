package com.company.RESTWebServiceGroupProject.service;

import com.company.RESTWebServiceGroupProject.dao.CustomerDao;
import com.company.RESTWebServiceGroupProject.dao.InvoiceDao;
import com.company.RESTWebServiceGroupProject.dao.InvoiceItemDao;
import com.company.RESTWebServiceGroupProject.dto.Customer;
import com.company.RESTWebServiceGroupProject.dto.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    InvoiceItemDao invoiceItemDao;

    @Autowired
    public CustomerService(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
    }

    @Autowired


    public Customer saveCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    public Customer findCustomer(int id) {
        return customerDao.getCustomer(id);
    }

    public List<Customer> findAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    @Transactional
    public void removeCustomer(int id) {
        List<Integer> invoiceIdList = invoiceDao.getInvoicesByCustomer(id).stream()
                .map(Invoice::getInvoiceId)
                .collect(Collectors.toList());

        for (Integer invoiceId : invoiceIdList) {
            invoiceItemDao.getInvoiceItemsByInvoiceId(invoiceId).stream()
                    .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));
        }

        invoiceIdList.stream()
                .forEach(invoiceId -> invoiceDao.deleteInvoice(invoiceId));

        customerDao.deleteCustomer(id);
    }
}
