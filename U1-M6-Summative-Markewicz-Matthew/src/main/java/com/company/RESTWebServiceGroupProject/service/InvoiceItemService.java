package com.company.RESTWebServiceGroupProject.service;

import com.company.RESTWebServiceGroupProject.dao.InvoiceItemDao;
import com.company.RESTWebServiceGroupProject.dao.ItemDao;
import com.company.RESTWebServiceGroupProject.dto.InvoiceItem;
import com.company.RESTWebServiceGroupProject.dto.Item;
import com.company.RESTWebServiceGroupProject.viewModels.InvoiceItemViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceItemService {

    InvoiceItemDao invoiceItemDao;
    ItemDao itemDao;

    @Autowired
    public InvoiceItemService(InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    @Transactional
    public InvoiceItemViewModel saveInvoiceItem(InvoiceItemViewModel invoiceItemViewModel) {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoiceItemViewModel.getInvoiceId());
        invoiceItem.setItemId(invoiceItemViewModel.getItem().getItemId());
        invoiceItem.setQuantity(invoiceItemViewModel.getQuantity());
        invoiceItem.setUnitPrice(invoiceItemViewModel.getUnitPrice());
        invoiceItem.setDiscount(invoiceItemViewModel.getDiscount());
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItemViewModel.setInvoiceItemId(invoiceItem.getInvoiceItemId());

        return invoiceItemViewModel;
    }

    public List<InvoiceItemViewModel> findAllItemsByInvoiceId(int invoiceId) {
        return invoiceItemDao.getInvoiceItemsByInvoiceId(invoiceId).stream()
                .map(this::buildInvoiceItemViewModel)
                .collect(Collectors.toList());
    }

    public void deleteInvoiceItem(int id) {
        invoiceItemDao.deleteInvoiceItem(id);
    }

    public InvoiceItemViewModel buildInvoiceItemViewModel(InvoiceItem invoiceItem) {
        Item item = itemDao.getItem(invoiceItem.getItemId());
        InvoiceItemViewModel iivm = new InvoiceItemViewModel();
        iivm.setInvoiceItemId(invoiceItem.getInvoiceItemId());
        iivm.setInvoiceItemId(invoiceItem.getInvoiceId());
        iivm.setItem(item);
        iivm.setQuantity(invoiceItem.getQuantity());
        iivm.setUnitPrice(invoiceItem.getUnitPrice());
        iivm.setDiscount(invoiceItem.getDiscount());
        return iivm;
    }
}
