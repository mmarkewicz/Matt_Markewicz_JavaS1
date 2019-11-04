package com.company.RESTWebServiceGroupProject.dao;

import com.company.RESTWebServiceGroupProject.dto.Invoice;
import com.company.RESTWebServiceGroupProject.dto.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {
    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);
    InvoiceItem getInvoiceItem(int id);
    List<InvoiceItem> getAllInvoiceItems();
    List<InvoiceItem> getInvoiceItemsByInvoiceId(int invoiceId);
    void updateInvoiceItem(InvoiceItem invoiceItem);
    void deleteInvoiceItem(int id);
}
