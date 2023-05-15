package com.example.taskforreview.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    private String name;

    @Column(name = "age")
    @Min(value = 10,  message = "You mini")
    private int age;

    @OneToMany(mappedBy = "person")
    @JsonManagedReference
    private List<Book> books;

    public Person() {
    }
}
