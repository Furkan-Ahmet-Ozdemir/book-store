package com.example.book_store.controller;

import com.example.book_store.dto.request.BookRequestDto;
import com.example.book_store.dto.response.BookResponseDto;
import com.example.book_store.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Controller")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    @PostMapping
    public ResponseEntity<BookResponseDto> create(@RequestBody BookRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(request));
    }

    @PutMapping
    public ResponseEntity<BookResponseDto> update(@RequestBody BookRequestDto request, Long bookId){
        return ResponseEntity.ok(bookService.update(request, bookId));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(Long bookId){
        return ResponseEntity.ok(bookService.delete(bookId));

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookResponseDto>> getAll(){
        return ResponseEntity.ok(bookService.getAll());
    }


}
