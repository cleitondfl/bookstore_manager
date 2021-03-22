package com.cleitonlima.bookstoremanager.controller;

import com.cleitonlima.bookstoremanager.dto.BookDTO;
import com.cleitonlima.bookstoremanager.dto.MessageResponseDTO;
import com.cleitonlima.bookstoremanager.service.BookService;
import com.cleitonlima.bookstoremanager.utils.BookUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.Mapping;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MockMvcExtensionsKt;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    private static final Object BOOK_API_URL_PATH = ;
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolverCustomizer)
                .setViewResolvers((viewName, locale) -> new Mapping())
                .build();
    }

    @Test
    void name (){
        void testWhenPOSTisCalledThenABookSholdBeCreated(){
            BookDTO bookDTO = BookUtils.createdFakeBookDTO();
            bookDTO.setIsbn("invalid isbn");

        mockMvc.perform(post(BOOK_API_URL_PATH))
        .contentType(mediaType.APPLICATION_JSON)
        .content(asJsonString(bookDTO)))
        .andExpect(status().isBadRequest());
        }

    }

    private OngoingStubbing<MessageResponseDTO> when(MessageResponseDTO messageResponseDTO) {
    }
}
