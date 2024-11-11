package com.gaberomero.bookrating.bookrating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rate")
    public ResponseEntity<Rating> rateBook(
        @RequestParam String userId,
        @RequestParam String bookId,
        @RequestParam int rating
    ) {
        // Check if the rating is between 1 and 5
        if (rating < 1 || rating > 5) {
            return ResponseEntity.badRequest().build(); // If not, return a bad request
         }

        Rating createdRating = ratingService.addRating(userId, bookId, rating); // Save the rating
        return ResponseEntity.ok(createdRating);  // Return the created rating object
    }
    
    @GetMapping("/{bookId}/ratings")
     public ResponseEntity<List<Rating>> getRatings(@PathVariable String bookId) {
        List<Rating> ratings = ratingService.getRatingsForBook(bookId);
        return ResponseEntity.ok(ratings);
}
}
