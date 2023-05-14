package com.example.taskforreview.facade;


import com.example.taskforreview.dto.BookDTO;
import com.example.taskforreview.entity.Book;
import com.example.taskforreview.service.BookService;
import com.example.taskforreview.util.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookFacade {
    private final BookService bookService;

    @Autowired
    public BookFacade(BookService bookService) {
        this.bookService = bookService;
    }

    public BookDTO getBook(int id) {
        Book book = bookService.getBook(id);
        return BookMapper.fromBookDTO(book);
    }

    public List<BookDTO> getBooks() {
        List<Book> books = bookService.getBooks();
        List<BookDTO> booksDTO = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = BookMapper.fromBookDTO(book);
            booksDTO.add(bookDTO);
        }
        return booksDTO;
    }

    public void addBook(BookDTO bookDTO) {
        bookService.addBook(BookMapper.fromBook(bookDTO));
    }

    public void deleteBook(int id) {
        bookService.deleteBook(id);
    }

    public void updateBook(BookDTO bookDTO) {
        Book book = BookMapper.fromBook(bookDTO);
        bookService.updateBook(book);
    }

}
