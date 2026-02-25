package com.library.bookapi.controller;


import com.library.bookapi.model.Book;
import com.library.bookapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET /api/books - Retrieve all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    //GET /api/books/{id} - Retrieve a book by its ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    //GET /api/books/isbn/{isbn} - Retrieve a book by its ISBN
    @GetMapping("/isbn/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

    //POST /api/books - Create a new book
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    //DELETE /api/books/{id} - Delete a book by its ID
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
