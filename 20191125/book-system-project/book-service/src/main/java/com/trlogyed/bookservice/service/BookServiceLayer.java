package com.trlogyed.bookservice.service;

import com.trlogyed.bookservice.dao.BookDao;
import com.trlogyed.bookservice.feign.NoteServiceFeign;
import com.trlogyed.bookservice.models.Book;
import com.trlogyed.bookservice.models.BookViewModel;
import com.trlogyed.bookservice.models.Note;
import com.trlogyed.bookservice.util.message.NoteEntry;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServiceLayer {

    BookDao bookDao;

    @Autowired
    NoteServiceFeign noteServiceFeign;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    public BookServiceLayer(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    private static final String EXCHANGE = "note-exchange";
    private static final String ROUTING_KEY = "note.controller";

    public BookViewModel fetchBookById(int id) throws Exception {
        try {
            BookViewModel bookViewModel = buildBookViewModel(bookDao.getBookById(id));
            List<Note> noteList = noteServiceFeign.getNotesByBookId(id);
            System.out.println(noteList);
            bookViewModel.setNotes(noteList);

            return bookViewModel;
        } catch (Exception e) {
            throw new Exception("Could not get book by ID");
        }
    }

    public List<BookViewModel> fetchAllBooks() throws Exception {
        try {
            List<Book> bookList = bookDao.getAllBooks();
            List<BookViewModel> bookViewModels =
                    bookList.stream()
                            .map(book -> buildBookViewModel(book))
                            .collect(Collectors.toList());
            return bookViewModels;
        } catch (Exception e) {
            throw new Exception("Could not fetch all books");
        }
    }

    public BookViewModel addBook(BookViewModel bookViewModel) throws Exception {
        try {
            Book book = new Book();
            book.setAuthor(bookViewModel.getAuthor());
            book.setTitle(bookViewModel.getTitle());
            book = bookDao.addBook(book);

            bookViewModel.setId(book.getId());

            // take all notes from book view model and send to the queue
            bookViewModel.getNotes().stream()
                    .forEach(note -> {
                        note.setBook_id(bookViewModel.getId()); // assign bookId to each note
                        NoteEntry noteEntry = new NoteEntry();
                        noteEntry.setBookId(note.getBook_id());
                        noteEntry.setNote(note.getNote());
                        noteEntry.setRequestType("POST");
                        System.out.println("Sending message...");
                        rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, noteEntry);
                        System.out.println("Message Sent");
                    });

            return bookViewModel;
        } catch (Exception e) {
            throw new Exception("Could not add book");
        }
    }

    public void updateBook(BookViewModel bookViewModel) throws Exception {
        try {

            // update book in bookdb
            Book book = new Book();
            book.setId(bookViewModel.getId());
            book.setTitle(bookViewModel.getTitle());
            book.setAuthor(bookViewModel.getAuthor());
            bookDao.updateBook(book);

            List<Note> noteList = noteServiceFeign.getNotesByBookId(book.getId());

            // get all note ids from database
            List<Integer> noteIdsFromDb = noteList.stream()
                    .map(note -> note.getId())
                    .collect(Collectors.toList());

            // filter through each note from the user
            for (Note note : bookViewModel.getNotes()) {
                // if note from user is not in the database
                if (!noteIdsFromDb.contains(note.getId())) {
                    note.setBook_id(book.getId()); // set the bookId in note to equal the current book
                    noteServiceFeign.postNote(note); // add book to the database
                }
            }
        } catch (Exception e) {
            throw new Exception("Could not update book");
        }
    }

    public void deleteBook(int id) throws Exception {
        try {
            List<Note> noteList = noteServiceFeign.getNotesByBookId(id);
            // delete each note with book_id
            noteList.stream()
                    .forEach(note -> noteServiceFeign.deleteNote(note.getId()));

            // delete book from db
            bookDao.deleteBook(id);
        } catch (Exception e) {
            throw new Exception("Could not delete book");
        }
    }

    private BookViewModel buildBookViewModel(Book book) {
        BookViewModel bookViewModel = new BookViewModel();
        bookViewModel.setId(book.getId());
        bookViewModel.setAuthor(book.getAuthor());
        bookViewModel.setTitle(book.getTitle());
        bookViewModel.setNotes(noteServiceFeign.getNotesByBookId(book.getId()));
        return bookViewModel;
    }
}
