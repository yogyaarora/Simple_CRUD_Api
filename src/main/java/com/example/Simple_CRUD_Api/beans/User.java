package com.example.Simple_CRUD_Api.beans;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotNull(message = "username can not be null")
    @NotBlank(message = "username can be empty")
    @Column(name = "username")
    private String username;

    @NotNull(message = "password can not be null")
    @NotBlank(message = "password can not be empty")
    @Pattern(regexp = "^[a-zA-Z0-9]{8}", message = "length must be 8")
    @Column(name = "password")
    private String password;

    @NotNull(message = "name can not be null")
    @NotBlank(message = "name can not be empty")
    @Column(name = "name")
    private String name;

    @NotNull(message = "age can not be null")
    @Positive(message = "age must be positive")
    @Column(name = "age")
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
