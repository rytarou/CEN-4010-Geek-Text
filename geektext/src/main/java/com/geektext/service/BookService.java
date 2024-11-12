package com.geektext.service;

import com.geektext.model.Book;
import com.geektext.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Adds a new book to the system.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    /**
     * Retrieves a book by its ISBN.
     *
     * @param isbn the ISBN of the book
     * @return the book if found, or null
     */
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn); // Ensure you have this method in your repository
    }
}
