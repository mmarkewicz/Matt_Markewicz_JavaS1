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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemDaoTest {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    InvoiceItemDao invoiceItemDao;

    @Before
    public void setUp(){
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        invoiceItemList.stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));

        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomer_id()));

        List<Item> itemList = itemDao.getAllItems();
        itemList.stream()
                .forEach(item -> itemDao.deleteItem(item.getItemId()));
    }

    @After
    public void tearDown() throws Exception {
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        invoiceItemList.stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));

        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream()
                .forEach(customer -> customerDao.deleteCustomer(customer.getCustomer_id()));

        List<Item> itemList = itemDao.getAllItems();
        itemList.stream()
                .forEach(item -> itemDao.deleteItem(item.getItemId()));
    }

    @Test
    public void addGetDeleteInvoiceItemTest(){
        Item item = new Item();
        item.setName("Item");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("9.99"));
        item = itemDao.addItem(item);

        Customer customer = new Customer();
        customer.setFirst_name("first");
        customer.setLast_name("last");
        customer.setEmail("email");
        customer.setCompany("company");
        customer.setPhone("2382312");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomer_id());
        invoice.setOrderDate(LocalDate.of(2019,10,31));

        invoice.setPickupDate(LocalDate.of(2019,11,5));
        invoice.setReturnDate(invoice.getPickupDate().plusDays(25));
        invoice.setLateFee(new BigDecimal("14.99"));
        invoiceDao.addInvoice(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitPrice(new BigDecimal("14.99"));
        invoiceItem.setDiscount(new BigDecimal("19.99"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        assertEquals(invoiceItem,invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId()));

        invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());

        List<InvoiceItem> invoiceItemList1 = invoiceItemDao.getAllInvoiceItems();

        assertEquals(0, invoiceItemList1.size());

    }

    @Test
    public void getAllInvoiceItemsTest(){
        Item item = new Item();
        item.setName("Item");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("9.99"));
        item = itemDao.addItem(item);

        Customer customer = new Customer();
        customer.setFirst_name("first");
        customer.setLast_name("last");
        customer.setEmail("email");
        customer.setCompany("company");
        customer.setPhone("2382312");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomer_id());
        invoice.setOrderDate(LocalDate.of(2019,10,31));

        invoice.setPickupDate(LocalDate.of(2019,11,5));
        invoice.setReturnDate(invoice.getPickupDate().plusDays(25));
        invoice.setLateFee(new BigDecimal("14.99"));
        invoiceDao.addInvoice(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitPrice(new BigDecimal("14.99"));
        invoiceItem.setDiscount(new BigDecimal("19.99"));
        invoiceItemDao.addInvoiceItem(invoiceItem);


        List<InvoiceItem> invoiceItems = invoiceItemDao.getAllInvoiceItems();
        assertEquals(1,invoiceItems.size());

    }

    @Test
    public void updateInvoiceItemTest(){
        Item item = new Item();
        item.setName("Item");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("9.99"));
        item = itemDao.addItem(item);

        Customer customer = new Customer();
        customer.setFirst_name("first");
        customer.setLast_name("last");
        customer.setEmail("email");
        customer.setCompany("company");
        customer.setPhone("2382312");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomer_id());
        invoice.setOrderDate(LocalDate.of(2019,10,31));

        invoice.setPickupDate(LocalDate.of(2019,11,5));
        invoice.setReturnDate(invoice.getPickupDate().plusDays(25));
        invoice.setLateFee(new BigDecimal("14.99"));
        invoiceDao.addInvoice(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitPrice(new BigDecimal("14.99"));
        invoiceItem.setDiscount(new BigDecimal("19.99"));
        InvoiceItem invoiceItemAdded = invoiceItemDao.addInvoiceItem(invoiceItem);

        invoiceItemAdded.setDiscount(new BigDecimal("25.00"));
        invoiceItemAdded.setQuantity(100);

        invoiceItemDao.updateInvoiceItem(invoiceItemAdded);

        InvoiceItem invoiceItemUpdated = invoiceItemDao.getInvoiceItem(invoiceItemAdded.getInvoiceItemId());

        assertEquals(invoiceItemAdded,invoiceItemUpdated);

    }

    @Test
    public void getInvoiceItemByInvoiceId(){
        Item item = new Item();
        item.setName("Item");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("9.99"));
        item = itemDao.addItem(item);

        Customer customer = new Customer();
        customer.setFirst_name("first");
        customer.setLast_name("last");
        customer.setEmail("email");
        customer.setCompany("company");
        customer.setPhone("2382312");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomer_id());
        invoice.setOrderDate(LocalDate.of(2019,10,31));

        invoice.setPickupDate(LocalDate.of(2019,11,5));
        invoice.setReturnDate(invoice.getPickupDate().plusDays(25));
        invoice.setLateFee(new BigDecimal("14.99"));
        invoiceDao.addInvoice(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitPrice(new BigDecimal("14.99"));
        invoiceItem.setDiscount(new BigDecimal("19.99"));
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);

        assertEquals(invoiceItemDao.getAllInvoiceItems(), invoiceItemDao.getInvoiceItemsByInvoiceId(invoice.getInvoiceId()));
    }
}
