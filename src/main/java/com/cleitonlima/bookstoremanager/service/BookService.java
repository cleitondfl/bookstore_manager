package com.cleitonlima.bookstoremanager.service;

import com.cleitonlima.bookstoremanager.dto.BookDTO;
import com.cleitonlima.bookstoremanager.dto.MessageResponseDTO;
import com.cleitonlima.bookstoremanager.entity.Book;
import com.cleitonlima.bookstoremanager.mapper.BookMapper;
import com.cleitonlima.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.ToModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }
    public BookDTO findById(Long id){
        Optional<Book> optionalBook = bookRepository.findById((id));

        return bookMapper.toDTO(optionalBook.get());

    }
}
