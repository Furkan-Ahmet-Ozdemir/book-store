package com.example.book_store.utils;

import com.example.book_store.model.Book;
import org.springframework.data.jpa.domain.Specification;


public class BookSpecification {
    public static Specification<Book> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name == null ? null : criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Book> hasAuthorName(String authorName) {
        return (root, query, criteriaBuilder) -> {
            if (authorName == null) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.join("authorList").get("name")), "%" + authorName.toLowerCase() + "%");
        };
    }

    public static Specification<Book> hasPublisherName(String publisherName) {
        return (root, query, criteriaBuilder) -> {
            if (publisherName == null) return null;
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("publisher").get("name")), "%" + publisherName.toLowerCase() + "%");
        };
    }

    public static Specification<Book> hasYearOfPublication(Integer year) {
        return (root, query, criteriaBuilder) ->
                year == null ? null : criteriaBuilder.equal(root.get("yearOfPublication"), year);
    }
}
