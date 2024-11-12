package com.geektext.controller;

import com.geektext.model.Book;
import com.geektext.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // POST request to create a new book
    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);  // Use bookService to save the book
            return new ResponseEntity<>("Book created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
        	return new ResponseEntity<>("Failed to create book", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn); // Call the service to get the book
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK); // Book found
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Book not found
        }
    }

}