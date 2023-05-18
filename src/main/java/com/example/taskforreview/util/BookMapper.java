package com.example.taskforreview.util;

import com.example.taskforreview.dto.BookDTO;
import com.example.taskforreview.dto.PersonDTO;
import com.example.taskforreview.entity.Book;
import com.example.taskforreview.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDTO fromBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setAuthor(book.getAuthor());

        Person person = book.getPerson();

        if (person != null) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setId(person.getId());
            personDTO.setName(person.getName());
            personDTO.setAge(person.getAge());
            bookDTO.setPerson(personDTO);
        }
        return bookDTO;
    }

    public Book fromBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());

        PersonDTO personDTO = bookDTO.getPerson();
        if (personDTO != null) {
            Person person = new Person();
            person.setId(personDTO.getId());
            person.setName(personDTO.getName());
            person.setAge(personDTO.getAge());
            book.setPerson(person);
        }
        return book;
    }
}
