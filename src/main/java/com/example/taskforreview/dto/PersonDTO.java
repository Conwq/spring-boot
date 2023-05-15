package com.example.taskforreview.dto;

import com.example.taskforreview.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {

    private int id;

    private String name;

    private int age;

    private List<Book> books;
}
