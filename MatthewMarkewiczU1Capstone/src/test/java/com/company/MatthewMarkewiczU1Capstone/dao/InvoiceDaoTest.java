package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.Invoice;
import com.company.MatthewMarkewiczU1Capstone.dto.ProcessingFee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    private InvoiceDao invoiceDao;

    @Before
    public void setUp() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));
    }

    @After
    public void tearDown() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.stream()
                .forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));
    }

    @Test
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setZipCode("12345");
        invoice.setUnitPrice(new BigDecimal(100.00));
        invoice.setTotal(new BigDecimal(400.00));
        invoice.setTax(new BigDecimal(30.00));
        invoice.setSubtotal(new BigDecimal(350.00));
        invoice.setStreet("Main St");
        invoice.setState("NJ");
        invoice.setQuantity(10);
        invoice.setProcessingFee(new BigDecimal(5.00));
        invoice.setItemType("Console");
        invoice.setCity("Jersey City");
        invoice.setItemId(3);
        invoice.setName("Test");
        invoice = invoiceDao.addInvoice(invoice);
        invoice.setUnitPrice(invoice.getUnitPrice().setScale(2, RoundingMode.HALF_EVEN));
        invoice.setSubtotal(invoice.getSubtotal().setScale(2, RoundingMode.HALF_EVEN));
        invoice.setTax(invoice.getTax().setScale(2, RoundingMode.HALF_EVEN));
        invoice.setProcessingFee(invoice.getProcessingFee().setScale(2, RoundingMode.HALF_EVEN));
        invoice.setTotal(invoice.getTotal().setScale(2, RoundingMode.HALF_EVEN));

        Invoice testInvoice = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice, testInvoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        assertEquals(invoiceDao.getAllInvoices().size(), 0);
    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setZipCode("12345");
        invoice.setUnitPrice(new BigDecimal(100.00));
        invoice.setTotal(new BigDecimal(400.00));
        invoice.setTax(new BigDecimal(30.00));
        invoice.setSubtotal(new BigDecimal(350.00));
        invoice.setStreet("Main St");
        invoice.setState("NJ");
        invoice.setQuantity(10);
        invoice.setProcessingFee(new BigDecimal(5.00));
        invoice.setItemType("Console");
        invoice.setCity("Jersey City");
        invoice.setItemId(3);
        invoice.setName("Test");
        invoiceDao.addInvoice(invoice);

        assertEquals(invoiceDao.getAllInvoices().size(), 1);
    }

    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setZipCode("12345");
        invoice.setUnitPrice(new BigDecimal(100.00));
        invoice.setTotal(new BigDecimal(400.00));
        invoice.setTax(new BigDecimal(30.00));
        invoice.setSubtotal(new BigDecimal(350.00));
        invoice.setStreet("Main St");
        invoice.setState("NJ");
        invoice.setQuantity(10);
        invoice.setProcessingFee(new BigDecimal(5.00));
        invoice.setItemType("Console");
        invoice.setCity("Jersey City");
        invoice.setItemId(3);
        invoice.setName("Test");
        invoice = invoiceDao.addInvoice(invoice);

        invoice.setState("NY");
        invoiceDao.updateInvoice(invoice);

        assertEquals(invoiceDao.getInvoice(invoice.getInvoiceId()).getState(), "NY");
    }
}
