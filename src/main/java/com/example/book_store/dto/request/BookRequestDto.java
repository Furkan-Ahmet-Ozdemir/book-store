package com.example.book_store.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    @Size(min = 1)
    @NotEmpty
    private String name;

    @Min( value = 1L)
    @NotNull
    private Integer yearOfPublication;

    @Min( value = 1L)
    @NotNull
    private Integer yearOfWritten;

    @Min( value = 1L)
    @NotNull
    private Integer numberOfPages;

    @NotNull
    private List<Long> authorIdList;
}
