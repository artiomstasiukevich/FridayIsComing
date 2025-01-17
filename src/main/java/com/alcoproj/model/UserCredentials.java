package com.alcoproj.model;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "usercredentials")
public class UserCredentials {

    @Id
    @Column(name = "credentials_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "password")
    private String password;

    @NaturalId
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    User user;

    public void updateUser(User user) {
        this.user.setName(user.getName());
        this.user.setAge(user.getAge());
        this.user.setEmail(user.getEmail());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
