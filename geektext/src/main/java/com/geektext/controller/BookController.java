package com.geektext.controller;

import com.geektext.model.Book;
import com.geektext.service.BookService;

import java.util.List;

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

    // POST to create a new book
    @PostMapping("/create")
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);  
            return new ResponseEntity<>("Book created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
        	return new ResponseEntity<>("Failed to create book", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // GET to retrieve books by author
    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String authorId) {
        try {
            List<Book> books = bookService.getBooksByAuthor(authorId); 
            if (books != null && !books.isEmpty()) {
                return new ResponseEntity<>(books, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
