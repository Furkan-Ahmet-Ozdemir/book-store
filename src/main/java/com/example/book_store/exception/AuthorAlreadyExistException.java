package com.example.book_store.exception;

public class AuthorAlreadyExistException extends RuntimeException {
    public AuthorAlreadyExistException(String message){
        super(message);
    }
}
