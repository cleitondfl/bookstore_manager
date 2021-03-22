package com.cleitonlima.bookstoremanager.mapper;

import com.cleitonlima.bookstoremanager.dto.BookDTO;
import com.cleitonlima.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book ToModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
