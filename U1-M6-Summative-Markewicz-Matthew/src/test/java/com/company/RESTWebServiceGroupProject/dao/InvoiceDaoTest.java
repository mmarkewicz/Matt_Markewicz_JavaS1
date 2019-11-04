package com.company.RESTWebServiceGroupProject.dao;

import com.company.RESTWebServiceGroupProject.dto.Customer;
import com.company.RESTWebServiceGroupProject.dto.Invoice;
import org.apache.el.lang.ELArithmetic;
import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    CustomerDao customerDao;
    @Autowired
    InvoiceDao invoiceDao;

    @Before
    public void setUp() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice((invoice.getInvoiceId())));
        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomer_id()));
    }

    @After
    public void tearDown() throws Exception {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice((invoice.getInvoiceId())));
        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomer_id()));
    }

    @Test
    public void addGetDeleteInvoice() {
        Customer customer = new Customer();
        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setCompany("Company");
        customer.setEmail("johndoe@company.com");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        LocalDate orderDate = LocalDate.of(2018, 10, 15);
        LocalDate pickupDate = LocalDate.of(2018, 11, 3);
        LocalDate returnDate = LocalDate.of(2018, 11, 30);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomer_id());
        invoice.setOrderDate(orderDate);
        invoice.setPickupDate(pickupDate);
        invoice.setReturnDate(returnDate);
        invoice.setLateFee(new BigDecimal("5.99"));
        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoiceFromDatabase = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice.toString(), invoiceFromDatabase.toString());
        assertEquals(invoiceDao.getAllInvoices().size(), 1);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        assertEquals(invoiceDao.getAllInvoices().size(), 0);
    }

    @Test
    public void updateInvoice() {
        Customer customer = new Customer();
        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setCompany("Company");
        customer.setEmail("johndoe@company.com");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        LocalDate orderDate = LocalDate.of(2018, 10, 15);
        LocalDate pickupDate = LocalDate.of(2018, 11, 3);
        LocalDate returnDate = LocalDate.of(2018, 11, 30);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomer_id());
        invoice.setOrderDate(orderDate);
        invoice.setPickupDate(pickupDate);
        invoice.setReturnDate(returnDate);
        invoice.setLateFee(new BigDecimal("5.99"));
        invoice = invoiceDao.addInvoice(invoice);

        invoice.setLateFee(new BigDecimal("10.99"));
        invoiceDao.updateInvoice(invoice);

        assertEquals(invoiceDao.getInvoice(invoice.getInvoiceId()).getLateFee(), new BigDecimal("10.99"));
    }

}
