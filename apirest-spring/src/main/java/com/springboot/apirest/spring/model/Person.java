package com.springboot.apirest.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    private String name;
    private String lastName;
    private String email;

}
