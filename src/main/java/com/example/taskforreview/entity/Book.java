package com.example.taskforreview.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Book")
@Table(name = "Book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
}
