package com.example.book_store.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message){
        super(message);
    }
}
