package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {

    private static final String INSERT_INVOICE_SQL =
            "INSERT INTO invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_INVOICE_SQL =
            "SELECT * FROM invoice WHERE invoice_id = ?";

    private static final String SELECT_ALL_INVOICES_SQL =
            "SELECT * FROM invoice";

    private static final String UPDATE_INVOICE_SQL =
            "UPDATE invoice SET name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type = ?, item_id = ?, unit_price = ?, quantity = ?, subtotal = ?, tax = ?, processing_fee = ?, total = ? WHERE invoice_id = ?";

    private static final String DELETE_INVOICE_SQL =
            "DELETE FROM invoice WHERE invoice_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipCode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal()
                );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        invoice.setInvoiceId(id);
        return invoice;
    }

    @Override
    public Invoice getInvoice(int id) {
        return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapRowToInvoice, id);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipCode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal(),
                invoice.getInvoiceId()
        );
    }

    @Override
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
    }

    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setCity(rs.getString("city"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setProcessingFee(rs.getBigDecimal("processing_fee"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setState(rs.getString("state"));
        invoice.setStreet(rs.getString("street"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setTotal(rs.getBigDecimal("total"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        invoice.setZipCode(rs.getString("zipcode"));
        invoice.setName(rs.getString("name"));
        return invoice;
    }
}