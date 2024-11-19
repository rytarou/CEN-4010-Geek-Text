package com.gaberomero.bookrating.bookrating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Create a new comment
    public Comment createComment(String userId, String bookId, String commentText) {
        Comment newComment = new Comment(userId, bookId, commentText);
        return commentRepository.save(newComment); // Save the comment to MongoDB
    }

    // Retrieve all comments for a specific book
    public List<Comment> getCommentsForBook(String bookId) {
        return commentRepository.findByBookId(bookId);
    }
}
