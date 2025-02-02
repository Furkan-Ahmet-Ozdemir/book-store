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
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public AuthorResponseDto create(AuthorRequestDto request){
        if(authorRepository.existsByNameAndSurName(request.getName(), request.getSurName())){
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
                .orElseThrow(() -> new AuthorNotFoundException("Author Not found"));

        author.setName(request.getName());
        author.setSurName(request.getSurName());

        Author savedAuthor = authorRepository.save(author);

        return  authorMapper.toDto(savedAuthor);
    }

    public boolean delete(Long authorId){
        if(authorRepository.findById(authorId).isEmpty()){
            throw new AuthorNotFoundException("Author Not found");
        }
        authorRepository.deleteById(authorId);
        return true;
    }

    public List<AuthorResponseDto> getAll(){
        List<Author> authors = authorRepository.findAll();

        return authors.stream()
                .map(author -> authorMapper.toDto(author))
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
