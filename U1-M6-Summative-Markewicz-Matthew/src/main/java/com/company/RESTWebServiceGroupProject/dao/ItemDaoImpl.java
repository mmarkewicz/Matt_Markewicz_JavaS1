package com.company.RESTWebServiceGroupProject.dao;

import com.company.RESTWebServiceGroupProject.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    private static final String INSERT_ITEM_SQL =
            "INSERT INTO item (name, description, daily_rate) VALUES (?, ?, ?)";

    private static final String SELECT_ITEM_SQL =
            "SELECT * FROM item WHERE item_id = ?";

    private static final String SELECT_ALL_ITEMS_SQL =
            "SELECT * FROM item";

    private static final String UPDATE_ITEM_SQL =
            "UPDATE item SET name = ?, description = ?, daily_rate = ? WHERE item_id = ?";

    private static final String DELETE_ITEM_SQL =
            "DELETE FROM item WHERE item_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Item addItem(Item item) {

        jdbcTemplate.update(INSERT_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate());

        int id = jdbcTemplate.queryForObject("SELECT last_insert_id()", Integer.class);

        item.setItemId(id);

        return item;
    }

    @Override
    public Item getItem(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_ITEM_SQL, this::mapRowToItem, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SELECT_ALL_ITEMS_SQL, this::mapRowToItem);
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(UPDATE_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate(),
                item.getItemId());
    }

    @Override
    public void deleteItem(int id) {
        jdbcTemplate.update(DELETE_ITEM_SQL, id);
    }

    private Item mapRowToItem(ResultSet rs, int rowNum) throws SQLException {

        Item item = new Item();
        item.setItemId(rs.getInt("item_id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setDailyRate(rs.getBigDecimal("daily_rate"));

        return item;
    }
}
