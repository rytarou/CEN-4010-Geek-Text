package com.geektext.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.geektext.model.Book;
import com.geektext.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getTopSellers() {
        return bookRepository.findTop10ByOrderByCopiesSoldDesc();
    }

    public List<Book> getBooksByRating(Double rating) {
        return bookRepository.findByRatingGreaterThanEqual(rating);
    }

    public void discountBooksByPublisher(String publisher, double discountPercent) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        for (Book book : books) {
            book.setPrice(book.getPrice() - (book.getPrice() * discountPercent / 100));
            bookRepository.save(book);
        }
    }
}
