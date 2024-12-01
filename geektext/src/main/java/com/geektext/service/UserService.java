package com.geektext;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.geektext.repository.UserRepository;
import com.geektext.model.CreditCard;
import com.geektext.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
        // You can add additional validation logic here (e.g., checking if the username or email already exists)
        return userRepository.save(user);
    }

    // Retrieve user by username
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    // Retrieve user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    // Update an existing user
    public User updateUser(String userId, User userDetails) {
        return userRepository.findById(userId).map(existingUser -> {
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            // Update other fields as needed
            return userRepository.save(existingUser);
        }).orElse(null);
    }
    
 // Add a credit card to a user
    public User addCreditCard(String userId, CreditCard creditCard) {
        return userRepository.findById(userId).map(user -> {
            if (user.getCreditCards() == null) {
                user.setCreditCards(new ArrayList<>());
            }
            user.getCreditCards().add(creditCard);
            return userRepository.save(user);
        }).orElse(null);
    }

    // Retrieve all credit cards for a user
    public List<CreditCard> getUserCreditCards(String userId) {
        return userRepository.findById(userId).map(User::getCreditCards).orElse(null);
    }

    // Delete a credit card by card number (last 4 digits only for security)
    public User deleteCreditCard(String userId, String lastFourDigits) {
        return userRepository.findById(userId).map(user -> {
            user.getCreditCards().removeIf(card -> card.getCardNumber().endsWith(lastFourDigits));
            return userRepository.save(user);
        }).orElse(null);
    }
}

