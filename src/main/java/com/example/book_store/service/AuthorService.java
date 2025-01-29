package com.example.book_store.service;

import com.example.book_store.dto.request.AuthorRequestDto;
import com.example.book_store.dto.response.AuthorResponseDto;
import com.example.book_store.exception.AuthorNotFoundException;
import com.example.book_store.model.Author;
import com.example.book_store.repository.AuthorRepository;
import com.example.book_store.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public AuthorResponseDto create(AuthorRequestDto request){

        Author author = new Author();
        author.setName(request.getName().trim());
        author.setSurName(request.getSurName().trim());

        Author savedAuthor = authorRepository.save(author);

        AuthorResponseDto responseDto = new AuthorResponseDto();
        responseDto.setName(savedAuthor.getName());
        responseDto.setSurName(savedAuthor.getSurName());

        return responseDto;
    }

    public AuthorResponseDto update(AuthorRequestDto request, Long authorId){

        Optional<Author> author = authorRepository.findById(authorId);
        if(author.get().getId() == null){
            throw new AuthorNotFoundException("Author Not found");
        }

        author.get().setName(request.getName());
        author.get().setSurName(request.getSurName());

        Author savedAuthor = authorRepository.save(author.get());

        AuthorResponseDto responseDto = new AuthorResponseDto();
        responseDto.setName(savedAuthor.getName());
        responseDto.setSurName(savedAuthor.getSurName());

        return responseDto;
    }

    public boolean delete(Long authorId){
        if(authorRepository.findById(authorId).isEmpty()){
            throw new AuthorNotFoundException("Author Not found");
        }
        authorRepository.deleteById(authorId);
        return true;
    }


}
