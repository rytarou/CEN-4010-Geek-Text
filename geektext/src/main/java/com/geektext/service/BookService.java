package com.geektext.service;

import com.geektext.model.Book;
import com.geektext.repository.BookRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /**
     * Adds a new book.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    /**
     * Retrieves a book ISBN.
     *
     * @param isbn the ISBN of the book
     * @return the book if found, or null
     */
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
    /**
     * Retrieves a list of books by an author's ID.
     *
     * @param authorId the author's ID
     * @return the list of books by that author
     */
    public List<Book> getBooksByAuthor(String authorId) {
        return bookRepository.findByAuthor(authorId);
    }
}
