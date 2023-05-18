package com.example.taskforreview.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {

    private int id;

    private String name;

    private int age;

    @JsonManagedReference
    private List<BookDTO> books;
}
