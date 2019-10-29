package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Component
public class PublisherDaoImpl implements PublisherDao {

    // prepared statements
    private static final String INSERT_PUBLISHER_SQL =
            "INSERT INTO publisher (name, street, city, state, postal_code, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_PUBLISHER_SQL =
            "SELECT * FROM publisher WHERE publisher_id = ?";

    private static final String SELECT_ALL_PUBLISHERS_SQL =
            "SELECT * FROM publisher";

    private static final String UPDATE_PUBLISHER_SQL =
            "UPDATE publisher SET name = ?, street = ?, city = ?, state = ?, postal_code = ?, phone = ?, email = ? WHERE publisher_id = ?";

    private static final String DELETE_PUBLISHER_SQL =
            "DELETE FROM publisher WHERE publisher_id = ?";

    private JdbcTemplate jdbcTemplate;

    public PublisherDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        jdbcTemplate.update(INSERT_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail()
        );

        int id = jdbcTemplate.queryForObject("SELECT last_insert_id()", Integer.class);
        publisher.setPublisher_id(id);
        return publisher;
    }

    @Override
    public Publisher getPublisher(int id) {
        return jdbcTemplate.queryForObject(SELECT_PUBLISHER_SQL, this::mapRowToPublisher, id);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return jdbcTemplate.query(SELECT_ALL_PUBLISHERS_SQL, this::mapRowToPublisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        jdbcTemplate.update(UPDATE_PUBLISHER_SQL,
                publisher.getName(),
                publisher.getStreet(),
                publisher.getCity(),
                publisher.getState(),
                publisher.getPostal_code(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getPublisher_id()
        );
    }

    @Override
    public void deletePublisher(int id) {
        jdbcTemplate.update(DELETE_PUBLISHER_SQL, id);
    }

    private Publisher mapRowToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setPublisher_id(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostal_code(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));
        return publisher;
    }

}
