package com.example.demo.service;

import com.equifax.library.model.Book;
import com.equifax.library.repository.BookRepo;
import com.equifax.library.service.BookService;
import com.equifax.library.service.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepo bookRepository;

    @Test
    public void shouldSaveBookSuccessfully() {
        final Book book = new Book();
        book.setBookId(4);
        book.setBookName("abc");
        book.setBookStatus("sucess");
        given(bookRepository.save(book))
                .willReturn(book);
        Book book2 =bookService.addBook(book);
        assertEquals( book2.getBookId(),4);

    }


    @Test
    public void shouldDeleteBookSuccessfully() {
        final Book book = new Book();
        book.setBookId(4);
        book.setBookName("abc");
        book.setBookStatus("sucess");
        bookService.deleteBook(book.getBookId());
        verify(bookRepository,times(1)).deleteById(book.getBookId());

    }

}
