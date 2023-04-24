package org.example.entity;

import org.example.annotatins.Column;
import org.example.annotatins.Id;
import org.example.annotatins.Table;

@Table(name="users")
public class User {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="username")
    private String username;
    @Column(name="age")
    private Integer age;

    public User() {
    }

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}