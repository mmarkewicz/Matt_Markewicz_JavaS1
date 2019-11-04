package com.company.RESTWebServiceGroupProject.service;

import com.company.RESTWebServiceGroupProject.dao.InvoiceItemDao;
import com.company.RESTWebServiceGroupProject.dao.InvoiceItemDaoImpl;
import com.company.RESTWebServiceGroupProject.dao.ItemDao;
import com.company.RESTWebServiceGroupProject.dao.ItemDaoImpl;
import com.company.RESTWebServiceGroupProject.dto.InvoiceItem;
import com.company.RESTWebServiceGroupProject.dto.Item;
import com.company.RESTWebServiceGroupProject.viewModels.InvoiceItemViewModel;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class InvoiceItemServiceTest {

    @Autowired
    private InvoiceItemService invoiceItemService;

    @MockBean
    private InvoiceItemDao invoiceItemDao;

    @MockBean
    private ItemService itemService;

    @Before
    public void setUp() throws Exception {
        setUpItemMock();
        setUpInvoiceItemMock();
    }

    @Test
    public void saveInvoiceItem() {
        Item item = new Item();
        item.setName("Item Name");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("14.99"));
        item = itemService.saveItem(item);

        InvoiceItemViewModel iivm = new InvoiceItemViewModel();
        iivm.setInvoiceId(1);
        iivm.setQuantity(5);
        iivm.setUnitPrice(new BigDecimal("19.99"));
        iivm.setDiscount(new BigDecimal("1.99"));
        iivm.setItem(item);

        iivm = invoiceItemService.saveInvoiceItem(iivm);
        assertEquals(iivm, invoiceItemService.findAllItemsByInvoiceId(1));

    }

    @Test
    public void findAllItemsByInvoiceId() {
    }

    @Test
    public void deleteInvoiceItem() {
    }

    @Test
    public void buildInvoiceItemViewModel() {
    }

    private void setUpItemMock() {
        Item item = new Item();
        item.setItemId(1);
        item.setName("Item Name");
        item.setDescription("Item Description");
        item.setDailyRate(new BigDecimal("14.99"));

        Item item1 = new Item();
        item1.setName("Item Name");
        item1.setDescription("Item Description");
        item1.setDailyRate(new BigDecimal("14.99"));

        List<Item> items = new ArrayList<>();
        items.add(item);

        doReturn(item).when(itemService.saveItem(item1));
        doReturn(item).when(itemService.findItem(1));
        doReturn(items).when(itemService.findAllItems());
    }

    private void setUpInvoiceItemMock() {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceItemId(1);
        invoiceItem.setInvoiceId(1);
        invoiceItem.setItemId(1);
        invoiceItem.setQuantity(5);
        invoiceItem.setUnitPrice(new BigDecimal("19.99"));
        invoiceItem.setDiscount(new BigDecimal("1.99"));

        InvoiceItem invoiceItem1 = new InvoiceItem();
        invoiceItem1.setInvoiceId(1);
        invoiceItem1.setItemId(1);
        invoiceItem1.setQuantity(5);
        invoiceItem1.setUnitPrice(new BigDecimal("19.99"));
        invoiceItem1.setDiscount(new BigDecimal("1.99"));

        List<InvoiceItem> invoiceItems = new ArrayList<>();
        invoiceItems.add(invoiceItem);

        doReturn(invoiceItem).when(invoiceItemDao).addInvoiceItem(invoiceItem1);
        doReturn(invoiceItems).when(invoiceItemDao).getInvoiceItemsByInvoiceId(1);
    }
}