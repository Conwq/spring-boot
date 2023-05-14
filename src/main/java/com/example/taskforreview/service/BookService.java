package com.example.taskforreview.service;

import com.example.taskforreview.entity.Book;
import com.example.taskforreview.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book getBook(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            throw new IllegalStateException("Book with id " + id + " not found");
        return optionalBook.get();
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty())
            throw new IllegalStateException("Book with id " + id + " to delete not found");
        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(Book book) {
        Optional<Book> optionalBook = bookRepository.findById(book.getId());
        if (optionalBook.isEmpty())
            throw new IllegalStateException("Book with id " + book.getId() + " to update not found");
        Book updateBook = optionalBook.get();
        updateBook.setName(book.getName());
        updateBook.setAuthor(book.getAuthor());
    }
}
