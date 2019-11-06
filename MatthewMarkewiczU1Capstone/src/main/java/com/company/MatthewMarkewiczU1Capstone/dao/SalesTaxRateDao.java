package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {
    SalesTaxRate getSalesTaxRate(String state);
    List<SalesTaxRate> getAllSalesTaxRates();
    void updateSalesTaxRate(SalesTaxRate salesTaxRate);
}
