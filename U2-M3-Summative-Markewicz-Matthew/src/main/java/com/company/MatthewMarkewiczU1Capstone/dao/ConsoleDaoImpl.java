package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoImpl implements ConsoleDao{

    private static final String INSERT_CONSOLE_SQL =
            "INSERT INTO console (model, manufacturer, memory_amount, processor, price, quantity) VALUES (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_CONSOLE_SQL =
            "SELECT * FROM console WHERE console_id = ?";

    private static final String SELECT_CONSOLE_BY_MANUFACTURER_SQL =
            "SELECT * FROM console WHERE manufacturer = ?";

    private static final String SELECT_ALL_CONSOLES_SQL =
            "SELECT * FROM console";

    private static final String UPDATE_CONSOLE_SQL =
            "UPDATE console SET model = ?, manufacturer = ?, memory_amount = ?, processor = ?, price = ?, quantity = ? WHERE console_id = ?";

    private static final String DELETE_CONSOLE_SQL =
            "DELETE FROM console WHERE console_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsoleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Console addConsole(Console console) {
        jdbcTemplate.update(INSERT_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity()
                );
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        console.setConsoleId(id);
        return console;
    }

    @Override
    public Console getConsole(int id) {
        return jdbcTemplate.queryForObject(SELECT_CONSOLE_SQL, this::mapRowToConsole, id);
    }

    @Override
    public List<Console> getAllConsoles() {
        return jdbcTemplate.query(SELECT_ALL_CONSOLES_SQL, this::mapRowToConsole);
    }

    @Override
    public List<Console> getConsolesByManufacturer(String manufacturer) { return jdbcTemplate.query(SELECT_CONSOLE_BY_MANUFACTURER_SQL, this::mapRowToConsole, manufacturer); }

    @Override
    public void updateConsole(Console console) {
        jdbcTemplate.update(UPDATE_CONSOLE_SQL,
                console.getModel(),
                console.getManufacturer(),
                console.getMemoryAmount(),
                console.getProcessor(),
                console.getPrice(),
                console.getQuantity(),
                console.getConsoleId()
                );
    }

    @Override
    public void deleteConsole(int id) {
        jdbcTemplate.update(DELETE_CONSOLE_SQL, id);
    }

    private Console mapRowToConsole(ResultSet rs, int rowNum) throws SQLException {
        Console console = new Console();
        console.setConsoleId(rs.getInt("console_id"));
        console.setManufacturer(rs.getString("manufacturer"));
        console.setMemoryAmount(rs.getString("memory_amount"));
        console.setModel(rs.getString("model"));
        console.setPrice(rs.getBigDecimal("price"));
        console.setProcessor(rs.getString("processor"));
        console.setQuantity(rs.getInt("quantity"));
        return console;
    }
}
