package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.ProcessingFee;
import com.company.MatthewMarkewiczU1Capstone.dto.SalesTaxRate;
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
public class SalesTaxRateDaoTest {

    @Autowired
    private SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    // update, get, get all
    @Test
    public void getSalesTaxRate() {
        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate("NJ");
        BigDecimal rate = salesTaxRate.getRate();

        assertEquals(rate.toString(), new BigDecimal(0.05).setScale(2, RoundingMode.HALF_EVEN).toString());
    }

    @Test
    public void getAllSalesTaxRates() {
        int salesTaxRateListSize = salesTaxRateDao.getAllSalesTaxRates().size();

        assertEquals(salesTaxRateListSize, 50);
    }

    @Test
    public void updateSalesTaxRate() {
        SalesTaxRate salesTaxRate = salesTaxRateDao.getSalesTaxRate("AL");
        assertEquals(salesTaxRate.getRate().toString(), new BigDecimal(0.05).setScale(2, RoundingMode.HALF_EVEN).toString());
    }
}
