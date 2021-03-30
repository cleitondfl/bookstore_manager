package com.cleitonlima.bookstoremanager.controller;

import com.cleitonlima.bookstoremanager.dto.BookDTO;
import com.cleitonlima.bookstoremanager.dto.MessageResponseDTO;
import com.cleitonlima.bookstoremanager.service.BookService;
import com.cleitonlima.bookstoremanager.utils.BookUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.Mapping;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    private static final Object BOOK_API_URL_PATH = ;
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    @RequestMapping("/api/v1/books")
    private BookController bookController;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(bookController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolverCustomizer)
                .setViewResolvers((viewName, locale) -> new Mapping())
                .build();
    }

    @Test
    void testWhenPOSTwithInvalidISBNsCalledThenBadRequestShouldBeReturned (){

            BookDTO bookDTO = BookUtils.createdFakeBookDTO();
            bookDTO.setIsbn("invalid isbn");

        mockMvc.perform(post(BOOK_API_URL_PATH))
        .contentType(mediaType.APPLICATION_JSON)
        .content(asJsonString(bookDTO)))
        .andExpect(status().isBadRequest());



    }

    private OngoingStubbing<MessageResponseDTO> when(MessageResponseDTO messageResponseDTO) {
    }
}
