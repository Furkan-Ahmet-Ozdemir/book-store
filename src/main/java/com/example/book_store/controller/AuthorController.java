package com.example.book_store.controller;

import com.example.book_store.dto.request.AuthorRequestDto;
import com.example.book_store.dto.response.AuthorResponseDto;
import com.example.book_store.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Author Controller")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> create(@RequestBody AuthorRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(request));
    }

    @PutMapping
    public ResponseEntity<AuthorResponseDto> update(AuthorRequestDto request, Long authorId){
        return ResponseEntity.ok(authorService.update(request, authorId));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(Long authorId){
        return ResponseEntity.ok(authorService.delete(authorId));

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AuthorResponseDto>> getAll(){
        return ResponseEntity.ok(authorService.getAll());
    }

    @GetMapping("/load-test-data")
    public boolean loadTestData(){
        return authorService.loadAuthorTestData();
    }


}
