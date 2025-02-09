package com.example.book_store.service;

import com.example.book_store.dto.request.PublisherRequestDto;
import com.example.book_store.dto.response.PublisherResponseDto;
import com.example.book_store.exception.PublisherAlreadyExistException;
import com.example.book_store.exception.PublisherNotFoundException;
import com.example.book_store.mapper.PublisherMapper;
import com.example.book_store.model.Publisher;
import com.example.book_store.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherResponseDto create(PublisherRequestDto request){
        log.info("PublisherService :: create() ::");

        if(publisherRepository.existsByName(request.getName())){
            log.error("PublisherService :: create() :: PublisherAlreadyExistException :: Publisher already exist");
            throw new PublisherAlreadyExistException("Publisher already exist");
        }

        Publisher publisher = publisherMapper.toEntity(request);
        
        Publisher savedpublisher = publisherRepository.save(publisher);
        return  publisherMapper.toDto(savedpublisher);
    }

    public PublisherResponseDto update(PublisherRequestDto request, Long publisherId){
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> {
                    log.error("PublisherService :: update() :: PublisherNotFoundException :: Publisher Not found");
                    return new PublisherNotFoundException("Publisher Not found");
                });

        publisher.setName(request.getName());
        
        Publisher savedpublisher = publisherRepository.save(publisher);
        return  publisherMapper.toDto(savedpublisher);
    }

    public boolean delete(Long publisherId){
        publisherRepository.findById(publisherId)
                .orElseThrow(() -> {
                    log.error("PublisherService :: delete() :: PublisherNotFoundException :: Publisher Not found");
                    return new PublisherNotFoundException("Publisher Not found");
                });

        publisherRepository.deleteById(publisherId);
        return true;
    }

    public List<PublisherResponseDto> getAll(){
        List<Publisher> publishers = publisherRepository.findAll();

        return publishers.stream()
                .map(publisherMapper::toDto)
                .toList();
    }
}
