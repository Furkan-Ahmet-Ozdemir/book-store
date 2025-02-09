package com.example.book_store.mapper;

import com.example.book_store.dto.request.PublisherRequestDto;
import com.example.book_store.dto.response.PublisherResponseDto;
import com.example.book_store.model.Publisher;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {
    public Publisher toEntity(PublisherRequestDto request){
        Publisher author = new Publisher();
        author.setName(request.getName());

        return author;
    }

    public PublisherResponseDto toDto(Publisher entity){
        PublisherResponseDto response = new PublisherResponseDto();
        response.setId(entity.getId());
        response.setName(entity.getName());

        return response;
    }
}
