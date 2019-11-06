package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeDaoImpl implements ProcessingFeeDao {

    private static final String INSERT_PROCESSING_FEE_SQL =
            "INSERT INTO processing_fee (product_type, fee) VALUES (?, ?)";

    private static final String SELECT_PROCESSING_FEE_SQL =
            "SELECT * FROM processing_fee WHERE product_type = ?";

    private static final String SELECT_ALL_PROCESSING_FEES_SQL =
            "SELECT * FROM processing_fee";

    private static final String UPDATE_PROCESSING_FEE_SQL =
            "UPDATE processing_fee SET fee = ? WHERE product_type = ?";

    private static final String DELETE_PROCESSING_FEE_SQL =
            "DELETE FROM processing_fee WHERE product_type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProcessingFee addProcessingFee(ProcessingFee processingFee) {
        jdbcTemplate.update(INSERT_PROCESSING_FEE_SQL,
                processingFee.getProductType(),
                processingFee.getFee()
                );
        return processingFee;
    }

    @Override
    public ProcessingFee getProcessingFee(String productType) {
        return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL, this::mapRowToProcessingFee, productType);
    }

    @Override
    public List<ProcessingFee> getAllProcessingFees() {
        return jdbcTemplate.query(SELECT_ALL_PROCESSING_FEES_SQL, this::mapRowToProcessingFee);
    }

    @Override
    public void updateProcessingFee(ProcessingFee processingFee) {
        jdbcTemplate.update(UPDATE_PROCESSING_FEE_SQL,
                processingFee.getFee(),
                processingFee.getProductType()
        );
    }

    @Override
    public void deleteProcessingFee(String productType) {
        jdbcTemplate.update(DELETE_PROCESSING_FEE_SQL, productType);
    }

    private ProcessingFee mapRowToProcessingFee(ResultSet rs, int rowNum) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(rs.getBigDecimal("fee"));
        processingFee.setProductType(rs.getString("product_type"));
        return processingFee;
    }
}
