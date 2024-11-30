package com.geektext.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geektext.model.Book;
import com.geektext.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/top-sellers")
    public List<Book> getTopSellers() {
        return bookService.getTopSellers();
    }

    @GetMapping("/rating/{rating}")
    public List<Book> getBooksByRating(@PathVariable Double rating) {
        return bookService.getBooksByRating(rating);
    }

    @PutMapping("/discount")
    public String discountBooks(@RequestBody DiscountRequest request) {
        bookService.discountBooksByPublisher(request.getPublisher(), request.getDiscountPercent());
        return "Discount applied successfully!";
    }
}