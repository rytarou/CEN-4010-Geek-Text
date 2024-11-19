package com.gaberomero.bookrating.bookrating;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "ratings")
public class Rating {
    @Id
    private String id;
    private String userId;
    private String bookId;
    private int rating; // Rating from 1 to 5
    private Date timestamp;

    public Rating(String userId, String bookId, int rating) {
        this.userId = userId;
        this.bookId = bookId;
        this.rating = rating;
        this.timestamp = new Date(); // Set the current time as the timestamp
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
