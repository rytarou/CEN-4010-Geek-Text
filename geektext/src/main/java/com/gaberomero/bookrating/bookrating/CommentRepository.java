package com.gaberomero.bookrating.bookrating;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {
    // Method to find all comments for a specific book by its ID
    List<Comment> findByBookId(String bookId);
}
