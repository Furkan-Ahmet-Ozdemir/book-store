package com.example.book_store.exception;

public class PublisherAlreadyExistException extends RuntimeException {
    public PublisherAlreadyExistException(String message){
        super(message);
    }
}
