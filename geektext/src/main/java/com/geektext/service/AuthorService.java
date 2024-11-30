package com.geektext.service;

import com.geektext.model.Author;
import com.geektext.repository.AuthorRepository;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /**
     * Adds author to the system.
     *
     * @param author the author to add
     */
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }
    /**
     * Retrieves author by ID.
     *
     * @param authorId to retrieve
     * @return the author, if found
     */
    public Author getAuthorByAuthorId(String authorId) {
        return authorRepository.findByAuthorId(authorId);
    }
    
}
