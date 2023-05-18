package com.example.taskforreview.util;

import com.example.taskforreview.dto.BookDTO;
import com.example.taskforreview.dto.PersonDTO;
import com.example.taskforreview.entity.Book;
import com.example.taskforreview.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMapper {

    public static PersonDTO fromPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setAge(person.getAge());
        personDTO.setName(person.getName());

        List<BookDTO> bookDTO = new ArrayList<>();
        for (Book book : person.getBooks()) {
            bookDTO.add(BookMapper.fromBookDTO(book));
        }
        personDTO.setBooks(bookDTO);
        return personDTO;
    }

    public static Person fromPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setAge(personDTO.getAge());
        person.setName(personDTO.getName());
        List<Book> book = new ArrayList<>();
        for (BookDTO bookDTO : personDTO.getBooks()) {
            book.add(BookMapper.fromBook(bookDTO));
        }
        person.setBooks(book);
        return person;
    }
}
