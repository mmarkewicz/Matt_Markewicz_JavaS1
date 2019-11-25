package com.trlogyed.noteservice;

import com.trlogyed.noteservice.dao.NoteDao;
import com.trlogyed.noteservice.models.Note;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class NoteDaoImplTest {

    @Autowired
    NoteDao noteDao;

    @Before
    public void setUp() {
        List<Note> noteList = noteDao.getAllNotes();
        noteList.stream()
                .forEach(note -> noteDao.deleteNote(note.getId()));
    }

    @After
    public void tearDown() {
        List<Note> noteList = noteDao.getAllNotes();
        noteList.stream()
                .forEach(note -> noteDao.deleteNote(note.getId()));
    }

    @Test
    public void addGetDeleteNote() {
        Note note = new Note();
        note.setNote("test");
        note.setBook_id(2);
        note = noteDao.createNote(note);

        assertEquals(note, noteDao.getNoteById(note.getId()));

        noteDao.deleteNote(note.getId());
        assertEquals(noteDao.getAllNotes().size(), 0);
    }

    @Test
    public void getNotesByBookId() {
        Note note = new Note();
        note.setNote("test");
        note.setBook_id(2);
        note = noteDao.createNote(note);

        List<Note> noteList = new ArrayList<>();
        noteList.add(note);

        assertEquals(noteList.toString(), noteDao.getNoteByBookId(2).toString());
    }

    @Test
    public void updateNote() {
        Note note = new Note();
        note.setNote("test");
        note.setBook_id(2);
        note = noteDao.createNote(note);

        note.setNote("new test");
        noteDao.updateNote(note);

        assertEquals(note, noteDao.getNoteById(note.getId()));
    }

    @Test
    public void deleteNote() {
        Note note = new Note();
        note.setNote("test");
        note.setBook_id(2);
        note = noteDao.createNote(note);

        assertEquals(noteDao.getAllNotes().size(), 1);

        noteDao.deleteNote(note.getId());
        assertEquals(noteDao.getAllNotes().size(), 0);
    }
}
