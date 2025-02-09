package com.example.book_store.exception;

public class PublisherNotFoundException extends RuntimeException {
  public PublisherNotFoundException(String message) {
    super(message);
  }
}
