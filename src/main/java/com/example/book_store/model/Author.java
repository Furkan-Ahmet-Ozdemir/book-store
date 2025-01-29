package com.example.book_store.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String surName;

    @ManyToOne
    @JoinColumn(name = "book_id" )
    private Book book;
}
