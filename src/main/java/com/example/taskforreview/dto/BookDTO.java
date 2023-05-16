package com.example.taskforreview.dto;

import com.example.taskforreview.entity.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
public class BookDTO {

    private int id;

    private String name;

    private String author;

//    @JsonIgnore
    @JsonManagedReference
    private Person person;
}
