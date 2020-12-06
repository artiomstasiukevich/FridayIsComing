package com.alcoproj.model;

import javax.persistence.*;

@Entity
@Table(name = "belovedalcohol")
public class BelovedAlcohol {
    @Id
    @Column(name = "belovedalco_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "alco_type")
    private Integer alcoType;


    public int getAlcoType() {
        return alcoType;
    }

    public void SetAlcoType(int alcoType) {
        this.alcoType = alcoType;
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
