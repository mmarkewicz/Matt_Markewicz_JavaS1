package com.trlogyed.bookservice.controller;

import com.trlogyed.bookservice.feign.NoteServiceFeign;
import com.trlogyed.bookservice.models.Book;
import com.trlogyed.bookservice.models.BookViewModel;
import com.trlogyed.bookservice.models.Note;
import com.trlogyed.bookservice.service.BookServiceLayer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    BookServiceLayer bookServiceLayer;

    @PostMapping("/books")
    public BookViewModel createBook(@RequestBody BookViewModel bookViewModel) throws Exception {
        return bookServiceLayer.addBook(bookViewModel);
    }

    @GetMapping("/books")
    public List<BookViewModel> getAllBooks() throws Exception {
        return bookServiceLayer.fetchAllBooks();
    }

    @GetMapping("/books/{id}")
    public BookViewModel getBookById(@PathVariable int id) throws Exception {
        return bookServiceLayer.fetchBookById(id);
    }

    @PutMapping("/books/{id}")
    public void updateBookById(@RequestBody BookViewModel bookViewModel, @PathVariable int id) throws Exception {
        bookViewModel.setId(id);
        bookServiceLayer.updateBook(bookViewModel);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBooksById(@PathVariable int id) throws Exception {
        bookServiceLayer.deleteBook(id);
    }
}
