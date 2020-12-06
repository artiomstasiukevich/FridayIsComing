package com.alcoproj.model;

import javax.persistence.*;

@Entity
@Table(name = "alcoholinbars")
public class AlcoholInBars {
    @Id
    @Column(name = "bar_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "alchol_id", nullable = false)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
