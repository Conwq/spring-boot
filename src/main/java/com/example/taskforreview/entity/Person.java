package com.example.taskforreview.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Column(name = "age")
    @Min(value = 12, message = "Age cannot be less than 12 years old")
    private int age;

    @OneToMany(mappedBy = "person")
    @JsonManagedReference
    private List<Book> books;

    public Person() {
    }
}
