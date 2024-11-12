package com.geektext.repository;

import com.geektext.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends MongoRepository<Book, String> {
	// Custom query method to find a book by its ISBN
    Book findByIsbn(String isbn);
}