package com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.service;

import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dao.*;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Console;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Game;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.Invoice;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.dto.TShirt;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.exceptions.InvalidStateCodeException;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.exceptions.QuantityGreaterThanInventoryException;
import com.company.MatthewMarkewiczU1CapstoneRefactoredJPA.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InvoiceService {

    private InvoiceRepository invoiceRepository;
    private GameRepository gameRepository;
    private TShirtRepository tShirtRepository;
    private ConsoleRepository consoleRepository;
    private SalesTaxRateRepository salesTaxRateRepository;
    private ProcessingFeeRepository processingFeeRepository;

    @Autowired
    InvoiceService(InvoiceRepository invoiceRepository, GameRepository gameRepository, TShirtRepository tShirtRepository, ConsoleRepository consoleRepository, SalesTaxRateRepository salesTaxRateRepository, ProcessingFeeRepository processingFeeRepository) {
        this.invoiceRepository = invoiceRepository;
        this.gameRepository = gameRepository;
        this.tShirtRepository = tShirtRepository;
        this.consoleRepository = consoleRepository;
        this.salesTaxRateRepository = salesTaxRateRepository;
        this.processingFeeRepository = processingFeeRepository;
    }

    public Invoice saveInvoice(@Valid InvoiceViewModel invoiceViewModel) throws Exception {
        Invoice invoice = getInvoiceFromInvoiceViewModel(invoiceViewModel);

        // set unit price
        switch(invoice.getItemType()) {
            case "t_shirt":
                invoice.setUnitPrice(tShirtRepository.getOne(invoice.getItemId()).getPrice());
                break;
            case "game":
                invoice.setUnitPrice(gameRepository.getOne(invoice.getItemId()).getPrice());
                break;
            case "console":
                invoice.setUnitPrice(consoleRepository.getOne(invoice.getItemId()).getPrice());
                break;
            default:
                throw new Exception("There are no items of that type in the inventory");
        }

        // set subtotal from quantity and unit price
        invoice.setSubtotal(new BigDecimal(invoice.getQuantity()).multiply(invoice.getUnitPrice()).setScale(2, RoundingMode.HALF_EVEN));

        // set tax, subtotal * tax rate from state
        try {
            invoice.setTax(salesTaxRateRepository.findByState(invoice.getState()).getRate().multiply(invoice.getSubtotal()).setScale(2, RoundingMode.HALF_EVEN));
        } catch (EmptyResultDataAccessException e) {
            throw new InvalidStateCodeException();
        }


        // set processing fee, if more than 10 items ordered, add additional fee
        if (invoice.getQuantity() <= 10) {
            invoice.setProcessingFee(processingFeeRepository.findByItemType(invoice.getItemType()).getFee().setScale(2, RoundingMode.HALF_EVEN));
        } else {
            invoice.setProcessingFee(processingFeeRepository.findByItemType(invoice.getItemType()).getFee().add(new BigDecimal(15.49)).setScale(2, RoundingMode.HALF_EVEN));
        }

        invoice.setTotal(invoice.getSubtotal().add(invoice.getTax()).add(invoice.getProcessingFee()).setScale(2, RoundingMode.HALF_EVEN));

        // if there are not enough products throw error
        // if user tries to submit an order for less than 1 product throw error
        // throw error from DAO?
        switch(invoice.getItemType()) {
            case "t_shirt":
                if (invoice.getQuantity() > tShirtRepository.getOne(invoice.getItemId()).getQuantity() || invoice.getQuantity() <= 0) {
                    throw new QuantityGreaterThanInventoryException();
                } else {
                    TShirt currentTShirt = tShirtRepository.getOne(invoice.getItemId()); // get tshirt from db
                    currentTShirt.setQuantity(currentTShirt.getQuantity() - invoice.getQuantity()); // update tshirt quantity to reflect user order
                    tShirtRepository.save(currentTShirt); // push updates to database
                }
                break;
            case "game":
                if (invoice.getQuantity() > gameRepository.getOne(invoice.getItemId()).getQuantity() || invoice.getQuantity() <= 0) {
                    throw new QuantityGreaterThanInventoryException();
                } else {
                    Game currentGame = gameRepository.getOne(invoice.getItemId());
                    currentGame.setQuantity(currentGame.getQuantity() - invoice.getQuantity());
                    gameRepository.save(currentGame);
                }
                break;
            case "console":
                if (invoice.getQuantity() > consoleRepository.getOne(invoice.getItemId()).getQuantity() || invoice.getQuantity() <= 0) {
                    throw new QuantityGreaterThanInventoryException();
                } else {
                    Console currentConsole = consoleRepository.getOne(invoice.getItemId());
                    currentConsole.setQuantity(currentConsole.getQuantity() - invoice.getQuantity());
                    consoleRepository.save(currentConsole);
                }
        }

        try {
            invoiceRepository.save(invoice);
            return invoice;
        } catch (Exception e) {
            throw new Exception("That invoice could not be added to the database");
        }
    }

    public @Valid InvoiceViewModel findInvoice(int invoiceId) throws Exception {
        try {
            Invoice invoice = invoiceRepository.getOne(invoiceId);
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