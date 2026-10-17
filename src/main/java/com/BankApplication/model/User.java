package com.BankApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// @Entity annotation indicates that the class is a JPA entity
// Entity mapped to the table with @Table
@Setter
@Getter
@Entity
// @Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    public User(int id, String name, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

}
