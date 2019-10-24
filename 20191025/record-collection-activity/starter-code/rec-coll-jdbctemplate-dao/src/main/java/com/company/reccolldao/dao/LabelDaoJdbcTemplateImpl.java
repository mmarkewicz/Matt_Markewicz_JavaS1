package com.company.reccolldao.dao;

import com.company.reccolldao.model.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LabelDaoJdbcTemplateImpl implements LabelDao {

    // prepared statements
    // insert label
    private static final String INSERT_LABEL_SQL =
            "INSERT INTO label (name, instagram, twitter) VALUES (?, ?, ?)";
    // get label
    private static final String SELECT_LABEL_SQL =
            "SELECT * FROM label WHERE label_id = ?";
    // get all labels
    private static final String SELECT_ALL_LABELS_SQL =
            "SELECT * FROM label";
    // update label
    private static final String UPDATE_LABEL_SQL =
            "UPDATE label SET name = ?, website = ? WHERE label_id = ?";
    // delete label
    private static final String DELETE_LABEL_SQL =
            "DELETE FROM label WHERE label_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LabelDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Label addLabel(Label label) {
        jdbcTemplate.update(INSERT_LABEL_SQL,
                label.getName(),
                label.getWebsite()
        );
        int id = jdbcTemplate.queryForObject("select last_insert_label_id()", Integer.class);
        label.setId(id);
        return label;
    }

    @Override
    public Label getLabel(int id) {
        return jdbcTemplate.queryForObject(SELECT_LABEL_SQL, this::mapRowToLabel, id);
    }

    @Override
    public List<Label> getAllLabels() {
        return jdbcTemplate.query(SELECT_ALL_LABELS_SQL, this::mapRowToLabel);
    }

    @Override
    public void updateLabel(Label label) {
        jdbcTemplate.update(INSERT_LABEL_SQL,
                label.getName(),
                label.getWebsite()
        );
    }

    @Override
    public void deleteLabel(int id) {
        jdbcTemplate.update(DELETE_LABEL_SQL, id);
    }

    private Label mapRowToLabel(ResultSet rs, int rowNum) throws SQLException {
        Label label = new Label();
        label.setId(rs.getInt("label_id"));
        label.setName(rs.getString("name"));
        label.setWebsite(rs.getString("website"));
        return label;
    }
}
