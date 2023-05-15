package com.example.taskforreview.util;

import com.example.taskforreview.dto.BookDTO;
import com.example.taskforreview.entity.Book;

public class BookMapper {

    public static BookDTO fromBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPerson(book.getPerson());
        return bookDTO;
    }

    public static Book fromBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setPerson(bookDTO.getPerson());
        return book;
    }
}
