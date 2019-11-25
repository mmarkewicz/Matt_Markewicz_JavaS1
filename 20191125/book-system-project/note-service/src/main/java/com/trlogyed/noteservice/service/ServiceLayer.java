package com.trlogyed.noteservice.service;

import com.trlogyed.noteservice.dao.NoteDao;
import com.trlogyed.noteservice.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLayer {

    @Autowired
    NoteDao noteDao;

    // crud + get note by book id
    public Note getNoteById(int id) {
        return noteDao.getNoteById(id);
    }

    public List<Note> getAllNotes() {
        return noteDao.getAllNotes();
    }

    public List<Note> getNotesByBookId(int bookId) {
        return noteDao.getNoteByBookId(bookId);
    }

    public Note addNote(Note note) {
        return noteDao.createNote(note);
    }

    public void updateNote(Note note) {
        noteDao.updateNote(note);
    }

    public void deleteNote(int id) {
        noteDao.deleteNote(id);
    }
}
