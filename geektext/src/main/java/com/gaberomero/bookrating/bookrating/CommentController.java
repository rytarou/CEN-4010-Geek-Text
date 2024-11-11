package com.gaberomero.bookrating.bookrating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Endpoint to create a comment
    @PostMapping("/{bookId}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable String bookId, 
                                              @RequestBody CommentRequest commentRequest) {
        Comment createdComment = commentService.createComment(commentRequest.getUserId(), 
                                                              bookId, 
                                                              commentRequest.getComment());
        return ResponseEntity.ok(createdComment);
    }

    // Endpoint to get all comments for a book
    @GetMapping("/{bookId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable String bookId) {
        List<Comment> comments = commentService.getCommentsForBook(bookId);
        return ResponseEntity.ok(comments);
    }
}

// DTO for comment request
class CommentRequest {
    private String userId;
    private String comment;

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
