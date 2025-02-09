package com.example.book_store.mapper;

import com.example.book_store.dto.request.BookRequestDto;
import com.example.book_store.dto.response.BookResponseDto;
import com.example.book_store.model.Book;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book toEntity(BookRequestDto request){
        Book book = new Book();
        book.setName(request.getName());
        book.setYearOfWritten(request.getYearOfWritten());
        book.setNumberOfPages(request.getNumberOfPages());
        book.setYearOfPublication(request.getYearOfPublication());

        return book;
    }

    public BookResponseDto toDto(Book entity){
        BookResponseDto response = new BookResponseDto();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setYearOfWritten(entity.getYearOfWritten());
        response.setNumberOfPages(entity.getNumberOfPages());
        response.setYearOfPublication(entity.getYearOfPublication());
        response.setAuthorNames(entity.getAuthorList().stream()
                .map(author -> author.getName()+ " " + author.getSurName())
                .collect(Collectors.toList()));
        response.setPublisherName(entity.getPublisher().getName());

        return response;
    }

    public void updateEntity(Book book, BookRequestDto request) {
        book.setName(request.getName());
        book.setYearOfWritten(request.getYearOfWritten());
        book.setNumberOfPages(request.getNumberOfPages());
        book.setYearOfPublication(request.getYearOfPublication());
    }
}
