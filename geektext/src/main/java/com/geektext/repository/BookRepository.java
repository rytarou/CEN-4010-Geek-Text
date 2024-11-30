package com.geektext.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.geektext.model.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findByRatingGreaterThanEqual(Double rating);
    List<Book> findTop10ByOrderByCopiesSoldDesc();
    List<Book> findByPublisher(String publisher);
}