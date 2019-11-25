package com.trlogyed.noteservice.controller;

import com.trlogyed.noteservice.models.Note;
import com.trlogyed.noteservice.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return serviceLayer.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable int id) {
        return serviceLayer.getNoteById(id);
    }

    @GetMapping("/notes/book/{id}")
    public List<Note> getNotesByBookId(@PathVariable int id) {
        return serviceLayer.getNotesByBookId(id);
    }

    @PostMapping("/notes")
    public Note postNote(@RequestBody Note note) {
        return serviceLayer.addNote(note);
    }

    @PutMapping("/notes/{id}")
    public void updateNote(@PathVariable int id, @RequestBody Note note) {
        note.setId(id);
        serviceLayer.updateNote(note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable int id) {
        serviceLayer.deleteNote(id);
    }
}
