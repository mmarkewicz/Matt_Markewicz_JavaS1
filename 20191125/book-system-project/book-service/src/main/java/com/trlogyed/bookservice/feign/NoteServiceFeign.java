package com.trlogyed.bookservice.feign;

import com.trlogyed.bookservice.models.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "note-service")
public interface NoteServiceFeign {
    @GetMapping("/notes/book/{id}")
    List<Note> getNotesByBookId(@PathVariable("id") int id);

    @GetMapping("/notes")
    List<Note> getAllNotes();

    @PostMapping("/notes")
    Note postNote(@RequestBody Note note);

    @PutMapping("/notes/{id}")
    void updateNote(@PathVariable int id, @RequestBody Note note);

    @DeleteMapping("/notes/{id}")
    void deleteNote(@PathVariable int id);
}
