package com.trlogyed.bookservice.dao;

import com.trlogyed.bookservice.models.Note;

import java.util.List;

public interface NoteDao {
    Note getNoteById(int id);
    List<Note> getNoteByBookId(int bookId);
    List<Note> getAllNotes();
    Note createNote(Note note);
    void updateNote(Note note);
    void deleteNote(int id);
}
