package com.example.book_store.mapper;

import com.example.book_store.dto.request.AuthorRequestDto;
import com.example.book_store.dto.response.AuthorResponseDto;
import com.example.book_store.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toEntity(AuthorRequestDto request){
        Author author = new Author();
        author.setName(request.getName());
        author.setSurName(request.getSurName());

        return author;
    }

    public AuthorResponseDto toDto(Author entity){
        AuthorResponseDto response = new AuthorResponseDto();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSurName(entity.getSurName());

        return response;
    }



}
