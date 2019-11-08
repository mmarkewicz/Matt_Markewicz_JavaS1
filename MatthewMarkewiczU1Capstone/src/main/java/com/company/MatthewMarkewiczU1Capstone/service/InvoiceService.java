package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.*;
import com.company.MatthewMarkewiczU1Capstone.dto.Console;
import com.company.MatthewMarkewiczU1Capstone.dto.Game;
import com.company.MatthewMarkewiczU1Capstone.dto.Invoice;
import com.company.MatthewMarkewiczU1Capstone.dto.TShirt;
import com.company.MatthewMarkewiczU1Capstone.exceptions.InvalidStateCodeException;
import com.company.MatthewMarkewiczU1Capstone.exceptions.QuantityGreaterThanInventoryException;
import com.company.MatthewMarkewiczU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InvoiceService {

    private InvoiceDao invoiceDao;
    private GameDao gameDao;
    private TShirtDao tShirtDao;
    private ConsoleDao consoleDao;
    private SalesTaxRateDao salesTaxRateDao;
    private ProcessingFeeDao processingFeeDao;

    @Autowired
    InvoiceService(InvoiceDao invoiceDao, GameDao gameDao, TShirtDao tShirtDao, ConsoleDao consoleDao, SalesTaxRateDao salesTaxRateDao, ProcessingFeeDao processingFeeDao) {
        this.invoiceDao = invoiceDao;
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
        this.consoleDao = consoleDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.processingFeeDao = processingFeeDao;
    }

    public Invoice saveInvoice(@Valid InvoiceViewModel invoiceViewModel) throws Exception {
        Invoice invoice = getInvoiceFromInvoiceViewModel(invoiceViewModel);

        // set unit price
        switch(invoice.getItemType()) {
            case "t_shirt":
                invoice.setUnitPrice(tShirtDao.getTShirt(invoice.getItemId()).getPrice());
                break;
            case "game":
                invoice.setUnitPrice(gameDao.getGame(invoice.getItemId()).getPrice());
                break;
            case "console":
                invoice.setUnitPrice(consoleDao.getConsole(invoice.getItemId()).getPrice());
                break;
            default:
                throw new Exception("There are no items of that type in the inventory");
        }

        // set subtotal from quantity and unit price
        invoice.setSubtotal(new BigDecimal(invoice.getQuantity()).multiply(invoice.getUnitPrice()).setScale(2, RoundingMode.HALF_EVEN));

        // set tax, subtotal * tax rate from state
        try {
            invoice.setTax(salesTaxRateDao.getSalesTaxRate(invoice.getState()).getRate().multiply(invoice.getSubtotal()).setScale(2, RoundingMode.HALF_EVEN));
        } catch (EmptyResultDataAccessException e) {
            throw new InvalidStateCodeException();
        }

        // set processing fee, if more than 10 items ordered, add additional fee
        if (invoice.getQuantity() <= 10) {
            invoice.setProcessingFee(processingFeeDao.getProcessingFee(invoice.getItemType()).getFee().setScale(2, RoundingMode.HALF_EVEN));
        } else {
            invoice.setProcessingFee(processingFeeDao.getProcessingFee(invoice.getItemType()).getFee().add(new BigDecimal(15.49)).setScale(2, RoundingMode.HALF_EVEN));
        }

        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()).setScale(2, RoundingMode.HALF_EVEN));

        switch(invoice.getItemType()) {
            case "t_shirt":
                if (invoice.getQuantity() > tShirtDao.getTShirt(invoice.getItemId()).getQuantity() || invoice.getQuantity() <= 0) {
                    throw new QuantityGreaterThanInventoryException();
                } else {
                    TShirt currentTShirt = tShirtDao.getTShirt(invoice.getItemId()); // get tshirt from db
                    currentTShirt.setQuantity(currentTShirt.getQuantity() - invoice.getQuantity()); // update tshirt quantity to reflect user order
                    tShirtDao.updateTShirt(currentTShirt); // push updates to database
                }
                break;
            case "game":
                if (invoice.getQuantity() > gameDao.getGame(invoice.getItemId()).getQuantity() || invoice.getQuantity() <= 0) {
                    throw new QuantityGreaterThanInventoryException();
                } else {
                    Game currentGame = gameDao.getGame(invoice.getItemId());
                    currentGame.setQuantity(currentGame.getQuantity() - invoice.getQuantity());
                    gameDao.updateGame(currentGame);
                }
                break;
            case "console":
                if (invoice.getQuantity() > consoleDao.getConsole(invoice.getItemId()).getQuantity() || invoice.getQuantity() <= 0) {
                    throw new QuantityGreaterThanInventoryException();
                } else {
                    Console currentConsole = consoleDao.getConsole(invoice.getItemId());
                    currentConsole.setQuantity(currentConsole.getQuantity() - invoice.getQuantity());
                    consoleDao.updateConsole(currentConsole);
                }
        }

        try {
            invoiceDao.addInvoice(invoice);
            return invoice;
        } catch (Exception e) {
            throw new Exception("That invoice could not be added to the database");
        }
    }

    public @Valid InvoiceViewModel findInvoice(int invoiceId) throws Exception {
        try {
            Invoice invoice = invoiceDao.getInvoice(invoiceId);
            return buildInvoiceViewModel(invoice);
        } catch (Exception e) {
            throw new Exception("Could not locate that invoice in the database");
        }
    }

    public Invoice getInvoiceFromInvoiceViewModel(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipCode(invoiceViewModel.getZip());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        return invoice;
    }

    public InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName(invoice.getName());
        invoiceViewModel.setStreet(invoice.getStreet());
        invoiceViewModel.setCity(invoice.getCity());
        invoiceViewModel.setState(invoice.getState());
        invoiceViewModel.setZip(invoice.getZipCode());
        invoiceViewModel.setItemType(invoice.getItemType());
        invoiceViewModel.setItemId(invoice.getItemId());
        invoiceViewModel.setQuantity(invoice.getQuantity());
        return invoiceViewModel;
    }
}