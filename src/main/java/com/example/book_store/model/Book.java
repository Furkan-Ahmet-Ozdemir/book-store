package com.example.book_store.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private Integer yearOfPublication;

    private Integer yearOfWritten;

    private Integer numberOfPages;

    @OneToMany
    @JoinColumn(name = "book_id" )
    private List<Author> authorList;
}
