package com.example.book_store.controller;

import com.example.book_store.dto.request.AuthorRequestDto;
import com.example.book_store.dto.response.AuthorResponseDto;
import com.example.book_store.model.Author;
import com.example.book_store.model.Book;
import com.example.book_store.service.AuthorService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/authors")
public class AuthorController {
   // private final AuthorService authorService;
//
//    public AuthorController(AuthorService authorService){
//        this.authorService = authorService;
//    }
//
//    @PostMapping
//    public ResponseEntity<AuthorResponseDto> create(AuthorRequestDto request){
//
//    }
//
//    @PutMapping
//    public ResponseEntity<AuthorResponseDto> update(AuthorRequestDto request){
//
//    }
//
//    @DeleteMapping
//    public Boolean delete(Long id){
//
//    }
//
//    @GetMapping("/get-all")
//    public ResponseEntity<List<AuthorResponseDto>> getAll(){
//
//    }





}
