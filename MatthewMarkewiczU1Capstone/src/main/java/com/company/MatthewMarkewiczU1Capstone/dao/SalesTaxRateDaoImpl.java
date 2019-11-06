package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoImpl implements SalesTaxRateDao {

    private static final String INSERT_SALES_TAX_RATE =
            "INSERT INTO sales_tax_rate (state, rate) VALUES (?, ?)";

    private static final String SELECT_SALES_TAX_RATE_SQL =
            "SELECT * FROM sales_tax_rate WHERE state = ?";

    private static final String SELECT_ALL_SALES_TAX_RATES_SQL =
            "SELECT * FROM sales_tax_rate";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxRateDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SalesTaxRate getSalesTaxRate(String state) {
        return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_SQL, this::mapRowToSalesTaxRate, state);
    }

    @Override
    public List<SalesTaxRate> getAllSalesTaxRates() {
        return jdbcTemplate.query(SELECT_ALL_SALES_TAX_RATES_SQL, this::mapRowToSalesTaxRate);
    }

    @Override
    public void updateSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(INSERT_SALES_TAX_RATE,
                salesTaxRate.getState(),
                salesTaxRate.getRate()
        );
    }


    private SalesTaxRate mapRowToSalesTaxRate(ResultSet rs, int rowNum) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setRate(rs.getBigDecimal("rate"));
        salesTaxRate.setState(rs.getString("state"));
        return salesTaxRate;
    }
}

//create table if not exists sales_tax_rate (
//    state char(2) not null,
//    rate decimal(3,2) not null
//);
