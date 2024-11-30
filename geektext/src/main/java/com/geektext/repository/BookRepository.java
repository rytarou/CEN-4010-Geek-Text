package com.geektext.repository;

import com.geektext.model.Book;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    Book findByIsbn(String isbn);
    List<Book> findByAuthor(String author);
}