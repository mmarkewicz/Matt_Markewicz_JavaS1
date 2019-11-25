package com.trlogyed.bookservice.dao;

import com.trlogyed.bookservice.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NoteDaoImpl implements NoteDao {

    // prepared statements
    private static final String SELECT_ALL_NOTES_SQL =
            "SELECT * FROM note";

    private static final String SELECT_NOTE_BY_ID_SQL =
            "SELECT * FROM note WHERE note_id = ?";

    private static final String SELECT_NOTE_BY_BOOK_ID_SQL =
            "SELECT * FROM note WHERE book_id = ?";

    private static final String INSERT_NOTE_SQL =
            "INSERT INTO note(book_id, note) VALUES (?, ?)";

    private static final String UPDATE_NOTE_SQL =
            "UPDATE note SET book_id = ?, note = ? WHERE note_id = ?";

    private static final String DELETE_NOTE_SQL =
            "DELETE FROM note WHERE note_id = ?";

    JdbcTemplate jdbcTemplate;

    @Autowired
    public NoteDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Note getNoteById(int id) {
        return jdbcTemplate.queryForObject(SELECT_NOTE_BY_ID_SQL, this::mapRowToNote, id);
    }

    @Override
    public List<Note> getNoteByBookId(int bookId) {
        return jdbcTemplate.query(SELECT_NOTE_BY_BOOK_ID_SQL, this::mapRowToNote, bookId);
    }

    @Override
    public List<Note> getAllNotes() {
        return jdbcTemplate.query(SELECT_ALL_NOTES_SQL, this::mapRowToNote);
    }

    @Override
    public Note createNote(Note note) {
        jdbcTemplate.update(INSERT_NOTE_SQL,
                note.getBook_id(),
                note.getNote()
                );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        note.setId(id);

        return note;
    }

    @Override
    public void updateNote(Note note) {
        jdbcTemplate.update(UPDATE_NOTE_SQL,
                note.getBook_id(),
                note.getNote(),
                note.getId()
                );
    }

    @Override
    public void deleteNote(int id) {
        jdbcTemplate.update(DELETE_NOTE_SQL, id);
    }

    private Note mapRowToNote(ResultSet rs, int rowNum) throws SQLException {
        Note note = new Note();
        note.setId(rs.getInt("note_id"));
        note.setBook_id(rs.getInt("book_id"));
        note.setNote(rs.getString("note"));
        return note;
    }
}
