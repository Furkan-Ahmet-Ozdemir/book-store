package com.example.book_store.service;

import com.example.book_store.dto.request.BookRequestDto;
import com.example.book_store.dto.response.BookResponseDto;
import com.example.book_store.exception.AuthorNotFoundException;
import com.example.book_store.exception.BookAlreadyExistException;
import com.example.book_store.exception.BookNotFoundException;
import com.example.book_store.mapper.BookMapper;
import com.example.book_store.model.Book;
import com.example.book_store.repository.AuthorRepository;
import com.example.book_store.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;

    public BookResponseDto create(BookRequestDto request){
        log.info("BookService :: create() ::");
        if(bookRepository.existsByName(request.getName())){
            log.error("BookService :: create() :: BookAlreadyExistException :: Book already exist");
            throw new BookAlreadyExistException("Book already exist");
        }

        Book toSave = bookMapper.toEntity(request);
        toSave.setAuthorList(
                request.getAuthorIdList().stream()
                        .map( authorId -> {
                            if(authorRepository.findById(authorId).isPresent()){
                                return authorRepository.findById(authorId).get();
                            }else {
                                log.error("BookService :: create() :: AuthorNotFoundException :: Author Not found");
                                throw new AuthorNotFoundException("Author Not found");
                            }
                        })
                        .toList()
        );

        return bookMapper.toDto(bookRepository.save(toSave));
    }

    public BookResponseDto update(BookRequestDto request, Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> {
                    log.error("BookService :: update() :: BookNotFoundException :: Book Not found");
                    return new BookNotFoundException("Book Not found");
                });

        bookMapper.updateEntity(book, request);
        book.setAuthorList(
                new ArrayList<>(request.getAuthorIdList().stream()
                        .map(authorId -> authorRepository.findById(authorId)
                                .orElseThrow(() -> {
                                    log.error("BookService :: update() :: AuthorNotFoundException :: Author Not found");
                                    return new AuthorNotFoundException("Author Not found");
                                })
                        ).toList()
                )
        );


        return bookMapper.toDto(bookRepository.save(book));
    }


    public boolean delete(Long bookId){
        bookRepository.findById(bookId)
                .orElseThrow(() -> {
                    log.error("BookService :: delete() :: BookNotFoundException :: Book Not found");
                    return new BookNotFoundException("Book Not found");
                });

        bookRepository.deleteById(bookId);
        return true;
    }

    public List<BookResponseDto> getAll(){
        List<Book> books = bookRepository.findAll();


        System.out.println();
        return books.stream()
                .map(bookMapper::toDto)
                .toList();
    }


}
