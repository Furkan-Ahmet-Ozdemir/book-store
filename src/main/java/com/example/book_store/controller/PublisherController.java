package com.example.book_store.controller;

import com.example.book_store.dto.request.PublisherRequestDto;
import com.example.book_store.dto.response.PublisherResponseDto;
import com.example.book_store.service.PublisherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
@Tag(name = "Publisher Controller")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherResponseDto> create(@RequestBody PublisherRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.create(request));
    }

    @PutMapping
    public ResponseEntity<PublisherResponseDto> update(PublisherRequestDto request, Long publisherId){
        return ResponseEntity.ok(publisherService.update(request, publisherId));
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(Long publisherId){
        return ResponseEntity.ok(publisherService.delete(publisherId));

    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PublisherResponseDto>> getAll(){
        return ResponseEntity.ok(publisherService.getAll());
    }
}
