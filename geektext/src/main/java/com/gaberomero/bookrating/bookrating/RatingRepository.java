package com.gaberomero.bookrating.bookrating;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RatingRepository extends MongoRepository<Rating, String> {
    List<Rating> findByBookId(String bookId);
}

