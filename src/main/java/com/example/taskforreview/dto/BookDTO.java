package com.example.taskforreview.dto;

import com.example.taskforreview.entity.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class BookDTO {

    private int id;

    private String name;

    private String author;

//    @JsonIgnore
    @JsonBackReference
    private PersonDTO person;
}
