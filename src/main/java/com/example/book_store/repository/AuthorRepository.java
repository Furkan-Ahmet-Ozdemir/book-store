package com.example.book_store.repository;



import com.example.book_store.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    boolean existsByNameAndSurName(String name, String surName);
}
