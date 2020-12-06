package com.alcoproj.model;

import javax.persistence.*;

@Entity
@Table(name = "preferredbar")
public class PreferredBar {
    @Id
    @Column(name = "prefbar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "bar_id")
    private Integer barId;


    public int getBarId() {
        return barId;
    }

    public void setBarId(int barId) {
        this.barId = barId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
