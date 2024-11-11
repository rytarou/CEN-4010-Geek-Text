package com.gaberomero.bookrating.bookrating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating addRating(String userId, String bookId, int rating) {
        Rating newRating = new Rating(userId, bookId, rating);
        return ratingRepository.save(newRating);  // Save the rating in MongoDB
    }

	public List<Rating> getRatingsForBook(String bookId) {
		return ratingRepository.findByBookId(bookId);
	}
}
