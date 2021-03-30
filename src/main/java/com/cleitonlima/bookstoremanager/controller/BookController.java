package com.cleitonlima.bookstoremanager.controller;

import com.cleitonlima.bookstoremanager.dto.BookDTO;
import com.cleitonlima.bookstoremanager.dto.MessageResponseDTO;
import com.cleitonlima.bookstoremanager.exception.BookNotFoundException;
import com.cleitonlima.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }
}