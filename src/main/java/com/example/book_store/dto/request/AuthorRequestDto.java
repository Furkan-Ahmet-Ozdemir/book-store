package com.example.book_store.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestDto {
    @Size(min = 3)
    @NotEmpty
    private String name;
    @Size(min = 1)
    @NotEmpty
    private String surName;
}
