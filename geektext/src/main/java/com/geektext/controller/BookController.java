package com.geektext.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

// DTO for discount request
class DiscountRequest {
    private String publisher;
    private double discountPercent;

    // Getters and Setters
}
