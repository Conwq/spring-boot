package com.example.taskforreview.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Data
public class BookDTO {

    private int id;

    private String name;

    private String author;

    @JsonBackReference
    private PersonDTO person;
}
