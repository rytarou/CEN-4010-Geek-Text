package com.geektext.repository;

import com.geektext.model.Author;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
	Author findByAuthorId(String authorId);
}
