package com.yakubozten.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @Column(name = "username")
    private String username;

    @Column(name = "firstname")
    private  String firstname;
    @Column(name = "lastname")
    private  String lastname;
}
