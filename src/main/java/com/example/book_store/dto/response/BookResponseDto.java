package com.example.book_store.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private String name;
    private Integer yearOfPublication;
    private Integer yearOfWritten;
    private Integer numberOfPages;
    private List<String> authorNames;
}
