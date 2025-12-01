package com.ipa.gateway.repository;

import com.ipa.gateway.domain.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Book entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long>, BookRepositoryInternal {
    Flux<Book> findAllBy(Pageable pageable);

    @Override
    <S extends Book> Mono<S> save(S entity);

    @Override
    Flux<Book> findAll();

    @Override
    Mono<Book> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface BookRepositoryInternal {
    <S extends Book> Mono<S> save(S entity);

    Flux<Book> findAllBy(Pageable pageable);

    Flux<Book> findAll();

    Mono<Book> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Book> findAllBy(Pageable pageable, Criteria criteria);
}
