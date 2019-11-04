package com.company.RESTWebServiceGroupProject.service;

import com.company.RESTWebServiceGroupProject.dao.CustomerDao;
import com.company.RESTWebServiceGroupProject.dao.InvoiceDao;
import com.company.RESTWebServiceGroupProject.dao.InvoiceItemDao;
import com.company.RESTWebServiceGroupProject.dto.Customer;
import com.company.RESTWebServiceGroupProject.dto.Invoice;
import com.company.RESTWebServiceGroupProject.viewModels.InvoiceItemViewModel;
import com.company.RESTWebServiceGroupProject.viewModels.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {

    InvoiceDao invoiceDao;
    InvoiceItemDao invoiceItemDao;
    CustomerDao customerDao;
    InvoiceItemService invoiceItemService;

    @Autowired
    public InvoiceService(InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, CustomerDao customerDao, InvoiceItemService invoiceItemService) {
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.customerDao = customerDao;
        this.invoiceItemService = invoiceItemService;
    }

    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(invoiceViewModel.getCustomer().getCustomer_id());
        invoice.setOrderDate(invoiceViewModel.getOrderDate());
        invoice.setPickupDate(invoiceViewModel.getPickupDate());
        invoice.setReturnDate(invoiceViewModel.getReturnDate());
        invoice.setLateFee(invoiceViewModel.getLateFee());
        invoice = invoiceDao.addInvoice(invoice);
        invoiceViewModel.setInvoiceId(invoice.getInvoiceId());

        return invoiceViewModel;
    }

    @Transactional
    public void removeInvoice(int id) {
        invoiceItemDao.getInvoiceItemsByInvoiceId(id).stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        invoiceDao.deleteInvoice(id);
    }

    public InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        List<InvoiceItemViewModel> invoiceItemViewModelList = invoiceItemDao.getInvoiceItemsByInvoiceId(invoice.getInvoiceId()).stream()
                .map(invoiceItem -> invoiceItemService.buildInvoiceItemViewModel(invoiceItem))
                .collect(Collectors.toList());
        Customer customer = customerDao.getCustomer(invoice.getCustomerId());

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setOrderDate(invoice.getOrderDate());
        ivm.setPickupDate(invoice.getPickupDate());
        ivm.setReturnDate(invoice.getReturnDate());
        ivm.setLateFee(invoice.getLateFee());
        ivm.setInvoiceItems(invoiceItemViewModelList);
        ivm.setCustomer(customer);

        return ivm;
    }
}
