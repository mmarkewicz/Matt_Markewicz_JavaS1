package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.TShirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TShirtDaoImpl implements TShirtDao {

    private static final String INSERT_T_SHIRT_SQL =
            "INSERT INTO t_shirt (size, color, description, price, quantity) VALUES (?, ?, ?, ?, ?)";

    private static final String SELECT_T_SHIRT_SQL =
            "SELECT * FROM t_shirt WHERE t_shirt_id = ?";

    private static final String SELECT_T_SHIRT_BY_SIZE_SQL =
            "SELECT * FROM t_shirt WHERE size = ?";

    private static final String SELECT_T_SHIRT_BY_COLOR_SQL =
            "SELECT * FROM t_shirt WHERE color = ?";

    private static final String SELECT_ALL_T_SHIRTS_SQL =
            "SELECT * FROM t_shirt";

    private static final String UPDATE_T_SHIRT_SQL =
            "UPDATE t_shirt SET size = ?, color = ?, description = ?, price = ?, quantity = ? WHERE t_shirt_id = ?";

    private static final String DELETE_T_SHIRT_SQL =
            "DELETE FROM t_shirt WHERE t_shirt_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TShirtDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public TShirt addTShirt(TShirt tShirt) {
        jdbcTemplate.update(INSERT_T_SHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity()
                );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        tShirt.setTShirtId(id);
        return tShirt;
    }

    @Override
    public TShirt getTShirt(int id) {
        return jdbcTemplate.queryForObject(SELECT_T_SHIRT_SQL, this::mapRowToTShirt, id);
    }

    @Override
    public List<TShirt> getTShirtsBySize(String size) { return jdbcTemplate.query(SELECT_T_SHIRT_BY_SIZE_SQL, this::mapRowToTShirt, size); }

    @Override
    public List<TShirt> getTShirtsByColor(String color) { return jdbcTemplate.query(SELECT_T_SHIRT_BY_COLOR_SQL, this::mapRowToTShirt, color); }

    @Override
    public List<TShirt> getAllTShirts() {
        return jdbcTemplate.query(SELECT_ALL_T_SHIRTS_SQL, this::mapRowToTShirt);
    }

    @Override
    public void updateTShirt(TShirt tShirt) {
        jdbcTemplate.update(UPDATE_T_SHIRT_SQL,
                tShirt.getSize(),
                tShirt.getColor(),
                tShirt.getDescription(),
                tShirt.getPrice(),
                tShirt.getQuantity(),
                tShirt.getTShirtId()
        );
    }

    @Override
    public void deleteTShirt(int id) {
        jdbcTemplate.update(DELETE_T_SHIRT_SQL, id);
    }

    private TShirt mapRowToTShirt(ResultSet rs, int rowNum) throws SQLException {
        TShirt tShirt = new TShirt();
        tShirt.setTShirtId(rs.getInt("t_shirt_id"));
        tShirt.setColor(rs.getString("color"));
        tShirt.setDescription(rs.getString("description"));
        tShirt.setPrice(rs.getBigDecimal("price"));
        tShirt.setQuantity(rs.getInt("quantity"));
        tShirt.setSize(rs.getString("size"));
        return tShirt;
    }
}
