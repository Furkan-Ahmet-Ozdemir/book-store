package com.example.book_store.exception;

public class BookAlreadyExistException extends RuntimeException {
    public BookAlreadyExistException(String message){
        super(message);
    }
}
