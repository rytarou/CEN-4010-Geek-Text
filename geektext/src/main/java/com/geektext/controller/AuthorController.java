package com.geektext.controller;

import com.geektext.model.Author;
import com.geektext.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // POST request to create a new author
    @PostMapping("/create")
    public ResponseEntity<String> createAuthor(@RequestBody Author author) {
        try {
            authorService.addAuthor(author);  
            return new ResponseEntity<>("Author created successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create author", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorByAuthorId(@PathVariable String authorId) {
        Author author = authorService.getAuthorByAuthorId(authorId);
        return author != null ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
    }
}
