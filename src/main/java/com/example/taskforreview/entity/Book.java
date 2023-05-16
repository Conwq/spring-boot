package com.example.taskforreview.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "Book")
@Table(name = "Book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Name book cannot be empty")
    private String name;

    @Column(name = "author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public Book(){
    }
}
