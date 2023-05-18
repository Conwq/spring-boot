package com.example.taskforreview.controller;

import com.example.taskforreview.dto.BookDTO;
import com.example.taskforreview.dto.PersonDTO;
import com.example.taskforreview.entity.Person;
import com.example.taskforreview.facade.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookFacade bookFacade;

    @Autowired
    public BookController(BookFacade bookFacade) {
        this.bookFacade = bookFacade;
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable("id") int id) {
        return bookFacade.getBook(id);
    }

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookFacade.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookFacade.addBook(bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookFacade.deleteBook(id);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable int id,
                           @RequestBody(required = false) BookDTO bookDTO) {
        bookDTO.setId(id);
        bookFacade.updateBook(bookDTO);
    }
}
