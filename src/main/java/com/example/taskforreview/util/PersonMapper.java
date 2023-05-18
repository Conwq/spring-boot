package com.example.taskforreview.util;

import com.example.taskforreview.dto.BookDTO;
import com.example.taskforreview.dto.PersonDTO;
import com.example.taskforreview.entity.Book;
import com.example.taskforreview.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonMapper {
    private final BookMapper bookMapper;

    @Autowired
    public PersonMapper (BookMapper bookMapper){
        this.bookMapper = bookMapper;
    }

    public PersonDTO fromPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setAge(person.getAge());
        personDTO.setName(person.getName());

        List<BookDTO> bookDTO = new ArrayList<>();
        for (Book book : person.getBooks()) {
            bookDTO.add(bookMapper.fromBookDTO(book));
        }
        personDTO.setBooks(bookDTO);
        return personDTO;
    }

    public Person fromPerson(PersonDTO personDTO) {
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setAge(personDTO.getAge());
        person.setName(personDTO.getName());
        List<Book> book = new ArrayList<>();
        for (BookDTO bookDTO : personDTO.getBooks()) {
            book.add(bookMapper.fromBook(bookDTO));
        }
        person.setBooks(book);
        return person;
    }
}
