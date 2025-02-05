package com.example.book_store.service;

import com.example.book_store.dto.request.AuthorRequestDto;
import com.example.book_store.dto.response.AuthorResponseDto;
import com.example.book_store.exception.AuthorAlreadyExistException;
import com.example.book_store.exception.AuthorNotFoundException;
import com.example.book_store.mapper.AuthorMapper;
import com.example.book_store.mapper.BookMapper;
import com.example.book_store.model.Author;
import com.example.book_store.repository.AuthorRepository;
import com.example.book_store.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorResponseDto create(AuthorRequestDto request){
        log.info("AuthorService :: create() ::");

        if(authorRepository.existsByNameAndSurName(request.getName(), request.getSurName())){
            log.error("AuthorService :: create() :: AuthorAlreadyExistException :: Author already exist");
            throw new AuthorAlreadyExistException("Author already exist");
        }

        Author author = new Author();
        author.setName(request.getName().trim());
        author.setSurName(request.getSurName().trim());

        Author savedAuthor = authorRepository.save(author);

        return  authorMapper.toDto(savedAuthor);
    }

    public AuthorResponseDto update(AuthorRequestDto request, Long authorId){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> {
                    log.error("AuthorService :: update() :: AuthorNotFoundException :: Author Not found");
                    return new AuthorNotFoundException("Author Not found");
                });

        author.setName(request.getName());
        author.setSurName(request.getSurName());

        Author savedAuthor = authorRepository.save(author);

        return  authorMapper.toDto(savedAuthor);
    }

    public boolean delete(Long authorId){
        authorRepository.findById(authorId)
                .orElseThrow(() -> {
                    log.error("AuthorService :: delete() :: AuthorNotFoundException :: Author Not found");
                    return new AuthorNotFoundException("Author Not found");
                });

        authorRepository.deleteById(authorId);
        return true;
    }

    public List<AuthorResponseDto> getAll(){
        List<Author> authors = authorRepository.findAll();

        return authors.stream()
                .map(authorMapper::toDto)
                .toList();
    }

    public boolean loadAuthorTestData(){
        List<String[]> authors = List.of(
                new String[]{"Jane", "Austen"},
                new String[]{"George", "Orwell"},
                new String[]{"Mark", "Twain"},
                new String[]{"J.K.", "Rowling"},
                new String[]{"Isaac", "Asimov"},
                new String[]{"Agatha", "Christie"},
                new String[]{"Charles", "Dickens"},
                new String[]{"Leo", "Tolstoy"},
                new String[]{"F. Scott", "Fitzgerald"},
                new String[]{"Harper", "Lee"}
        );

        authors.forEach(authorData -> {
            Author author = new Author();
            author.setName(authorData[0].trim());
            author.setSurName(authorData[1].trim());

            authorRepository.save(author);
        });
        return true;
    }

}
