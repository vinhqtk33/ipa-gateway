package com.ipa.gateway.service.mapper;

import com.ipa.gateway.domain.Book;
import com.ipa.gateway.service.dto.BookDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Book} and its DTO {@link BookDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookMapper extends EntityMapper<BookDTO, Book> {}
