package service;

import com.cleitonlima.bookstoremanager.dto.BookDTO;
import com.cleitonlima.bookstoremanager.entity.Book;
import com.cleitonlima.bookstoremanager.repository.BookRepository;
import com.cleitonlima.bookstoremanager.service.BookService;
import com.cleitonlima.bookstoremanager.utils.BookUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void whenGivenExistingIdThenReturnThisBook() {
        Book expectedFoundBook = createFakeBook();

        Mockito.when(bookRepository.findById(expectedFoundBook.getId())).thenReturn(Optional.of(expectedFoundBook));

       BookDTO bookDTO = bookService.findById(expectedFoundBook.getId());

        Assertions.assertEquals(expectedFoundBook.getName(), bookDTO.getName());
        Assertions.assertEquals(expectedFoundBook.getIsbn(), bookDTO.getIsbn());
        Assertions.assertEquals(expectedFoundBook.getPublisherName(), bookDTO.getPublisherName(), bookDTO.getPublisherName());
    }
}
