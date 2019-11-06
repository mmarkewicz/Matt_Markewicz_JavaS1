package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.*;
import com.company.MatthewMarkewiczU1Capstone.dto.Invoice;
import com.company.MatthewMarkewiczU1Capstone.dto.ProcessingFee;
import com.company.MatthewMarkewiczU1Capstone.dto.SalesTaxRate;
import com.company.MatthewMarkewiczU1Capstone.dto.TShirt;
import com.company.MatthewMarkewiczU1Capstone.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {

    InvoiceService invoiceService;
    GameDao gameDao;
    ConsoleDao consoleDao;

    @Mock
    TShirtDao tShirtDao;
    @Mock
    SalesTaxRateDao salesTaxRateDao;
    @Mock
    ProcessingFeeDao processingFeeDao;
    @Mock
    InvoiceDao invoiceDao;

    @Before
    public void setUp() {
        setUpInvoiceMocks();

        invoiceService = new InvoiceService(invoiceDao, gameDao, tShirtDao, consoleDao, salesTaxRateDao, processingFeeDao);
    }

    @Test
    public void shouldReturnInvoiceViewModelFromServiceLayer() {
        Invoice invoice = new Invoice();
        invoice.setName("John Doe");
        invoice.setStreet("Main St.");
        invoice.setCity("Test");
        invoice.setState("NJ");
        invoice.setZipCode("12345");
        invoice.setItemType("t_shirt");
        invoice.setItemId(3);
        invoice.setUnitPrice(new BigDecimal(10.00));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal(1000.00));
        invoice.setTax(new BigDecimal(10.00));
        invoice.setProcessingFee(new BigDecimal(10.00));
        invoice.setTotal(new BigDecimal(1020.00));

        InvoiceViewModel invoiceViewModel = invoiceService.buildInvoiceViewModel(invoice);

        assertEquals(invoiceViewModel, invoiceService.findInvoice(100));
    }

    @Test
    public void shouldReturnInvoiceFromInvoiceViewModel() {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(100);
        invoice.setName("John Doe");
        invoice.setStreet("Main St.");
        invoice.setCity("Test");
        invoice.setState("NJ");
        invoice.setZipCode("12345");
        invoice.setItemType("t_shirt");
        invoice.setItemId(3);
        invoice.setUnitPrice(new BigDecimal(10.00));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal(40.00).setScale(2, RoundingMode.HALF_EVEN));
        invoice.setTax(new BigDecimal(2.00).setScale(2, RoundingMode.HALF_EVEN));
        invoice.setProcessingFee(new BigDecimal(10.00).setScale(2, RoundingMode.HALF_EVEN));
        invoice.setTotal(new BigDecimal(52.00).setScale(2, RoundingMode.HALF_EVEN));

        Invoice invoiceFromServiceLayer = invoiceService.saveInvoice(invoiceService.buildInvoiceViewModel(invoice));
        invoiceFromServiceLayer.setInvoiceId(100);

        assertEquals(invoice, invoiceFromServiceLayer);
        // HOW TO MOCK ALL DEPENDENCIES
    }

    public void setUpInvoiceMocks() {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(100);
        invoice.setName("John Doe");
        invoice.setStreet("Main St.");
        invoice.setCity("Test");
        invoice.setState("NJ");
        invoice.setZipCode("12345");
        invoice.setItemType("t_shirt");
        invoice.setItemId(3);
        invoice.setUnitPrice(new BigDecimal(10.00));
        invoice.setQuantity(4);
        invoice.setSubtotal(new BigDecimal(1000.00));
        invoice.setTax(new BigDecimal(10.00));
        invoice.setProcessingFee(new BigDecimal(10.00));
        invoice.setTotal(new BigDecimal(1020.00));

        Invoice invoiceWithoutId = new Invoice();
        invoiceWithoutId.setName("John Doe");
        invoiceWithoutId.setStreet("Main St.");
        invoiceWithoutId.setCity("Test");
        invoiceWithoutId.setState("NJ");
        invoiceWithoutId.setZipCode("12345");
        invoiceWithoutId.setItemType("t_shirt");
        invoiceWithoutId.setItemId(3);
        invoiceWithoutId.setUnitPrice(new BigDecimal(10.00));
        invoiceWithoutId.setQuantity(4);
        invoiceWithoutId.setSubtotal(new BigDecimal(1000.00));
        invoiceWithoutId.setTax(new BigDecimal(10.00));
        invoiceWithoutId.setProcessingFee(new BigDecimal(10.00));
        invoiceWithoutId.setTotal(new BigDecimal(1020.00));

        TShirt tShirt = new TShirt();
        tShirt.setColor("Black");
        tShirt.setQuantity(10);
        tShirt.setTShirtId(3);
        tShirt.setSize("Medium");
        tShirt.setDescription("A black tee");
        tShirt.setPrice(new BigDecimal(10.00));

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal(10.00));
        processingFee.setProductType("t_shirt");

        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("NJ");
        salesTaxRate.setRate(new BigDecimal(0.05));

        doReturn(invoice).when(invoiceDao).getInvoice(100);
        doReturn(invoice).when(invoiceDao).addInvoice(invoiceWithoutId);
        doReturn(tShirt).when(tShirtDao).getTShirt(invoice.getItemId());
        doReturn(processingFee).when(processingFeeDao).getProcessingFee("t_shirt");
        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("NJ");
    }
}
