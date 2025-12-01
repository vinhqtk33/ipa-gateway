package com.ipa.gateway.service;

import com.ipa.gateway.service.dto.BookDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.ipa.gateway.domain.Book}.
 */
public interface BookService {
    /**
     * Save a book.
     *
     * @param bookDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<BookDTO> save(BookDTO bookDTO);

    /**
     * Updates a book.
     *
     * @param bookDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<BookDTO> update(BookDTO bookDTO);

    /**
     * Partially updates a book.
     *
     * @param bookDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<BookDTO> partialUpdate(BookDTO bookDTO);

    /**
     * Get all the books.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<BookDTO> findAll(Pageable pageable);

    /**
     * Returns the number of books available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" book.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<BookDTO> findOne(Long id);

    /**
     * Delete the "id" book.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
