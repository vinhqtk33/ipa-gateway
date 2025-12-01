package com.ipa.gateway.service.impl;

import com.ipa.gateway.repository.BookRepository;
import com.ipa.gateway.service.BookService;
import com.ipa.gateway.service.dto.BookDTO;
import com.ipa.gateway.service.mapper.BookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.ipa.gateway.domain.Book}.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {

    private static final Logger LOG = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Mono<BookDTO> save(BookDTO bookDTO) {
        LOG.debug("Request to save Book : {}", bookDTO);
        return bookRepository.save(bookMapper.toEntity(bookDTO)).map(bookMapper::toDto);
    }

    @Override
    public Mono<BookDTO> update(BookDTO bookDTO) {
        LOG.debug("Request to update Book : {}", bookDTO);
        return bookRepository.save(bookMapper.toEntity(bookDTO)).map(bookMapper::toDto);
    }

    @Override
    public Mono<BookDTO> partialUpdate(BookDTO bookDTO) {
        LOG.debug("Request to partially update Book : {}", bookDTO);

        return bookRepository
            .findById(bookDTO.getId())
            .map(existingBook -> {
                bookMapper.partialUpdate(existingBook, bookDTO);

                return existingBook;
            })
            .flatMap(bookRepository::save)
            .map(bookMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<BookDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Books");
        return bookRepository.findAllBy(pageable).map(bookMapper::toDto);
    }

    public Mono<Long> countAll() {
        return bookRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<BookDTO> findOne(Long id) {
        LOG.debug("Request to get Book : {}", id);
        return bookRepository.findById(id).map(bookMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        LOG.debug("Request to delete Book : {}", id);
        return bookRepository.deleteById(id);
    }
}
