package com.example.taskforreview.dto;

import com.example.taskforreview.entity.Person;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BookDTO {

    private int id;

    private String name;

    private String author;

    private Person person;
}
