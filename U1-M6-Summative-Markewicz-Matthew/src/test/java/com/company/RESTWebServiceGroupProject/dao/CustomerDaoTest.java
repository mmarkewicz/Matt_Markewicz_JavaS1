package com.company.RESTWebServiceGroupProject.dao;

import com.company.RESTWebServiceGroupProject.dto.Customer;
import com.company.RESTWebServiceGroupProject.dto.Invoice;
import com.company.RESTWebServiceGroupProject.dto.InvoiceItem;
import com.company.RESTWebServiceGroupProject.dto.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoTest {

    @Autowired
    CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomer_id()));
    }

    @After
    public void tearDown() throws Exception {
        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomer_id()));
    }

    @Test
    public void addGetDeleteCustomer() {
        Customer customer = new Customer();
        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setCompany("Company");
        customer.setEmail("johndoe@company.com");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        Customer customer1 = customerDao.getCustomer(customer.getCustomer_id());
        assertEquals(customer, customer1);

        customerDao.deleteCustomer(customer.getCustomer_id());
        customer1 = customerDao.getCustomer(customer.getCustomer_id());
        assertNull(customer1);
    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setCompany("Company");
        customer.setEmail("johndoe@company.com");
        customer.setPhone("123-456-7890");
        customerDao.addCustomer(customer);

        customer = new Customer();
        customer.setFirst_name("Jane");
        customer.setLast_name("Doe");
        customer.setCompany("Company");
        customer.setEmail("janedoe@company.com");
        customer.setPhone("123-456-7890");
        customerDao.addCustomer(customer);

        List<Customer> customerList = customerDao.getAllCustomers();
        assertEquals(2, customerList.size());
    }

    @Test
    public void updateCustomer() {
        Customer customer = new Customer();
        customer.setFirst_name("John");
        customer.setLast_name("Doe");
        customer.setCompany("Company");
        customer.setEmail("johndoe@company.com");
        customer.setPhone("123-456-7890");
        customer = customerDao.addCustomer(customer);

        customer.setFirst_name("UPDATED");
        customer.setLast_name("UPDATED");
        customer.setCompany("UPDATED");
        customerDao.updateCustomer(customer);

        Customer customer1 = customerDao.getCustomer(customer.getCustomer_id());
        assertEquals(customer, customer1);
    }
}