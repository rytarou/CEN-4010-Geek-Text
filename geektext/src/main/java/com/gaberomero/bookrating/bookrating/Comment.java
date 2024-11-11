package com.gaberomero.bookrating.bookrating;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "comments") // Specifies that this model will be stored in the "comments" collection in MongoDB
public class Comment {

    @Id
    private String id; // This will be the unique identifier for each comment
    private String userId; // The ID of the user who made the comment
    private String bookId; // The ID of the book being commented on
    private String comment; // The actual text of the comment
    private LocalDateTime timestamp; // The time the comment was made

    // Constructor
    public Comment(String userId, String bookId, String comment) {
        this.userId = userId;
        this.bookId = bookId;
        this.comment = comment;
        this.timestamp = LocalDateTime.now(); // Automatically set the timestamp to the current time
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
