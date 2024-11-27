package com.geektext.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findByRatingGreaterThanEqual(Double rating);
    List<Book> findTop10ByOrderByCopiesSoldDesc();
    List<Book> findByPublisher(String publisher);
}

public interface AuthorRepository extends MongoRepository<Author, String> {
}
