package com.alcoproj.model;

import javax.persistence.*;

@Entity
@Table(name = "alcohol")
public class Alcohol {

    @Id
    @Column(name = "alcohol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private AlcType alcType;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany() {
        this.company = company;
    }

    public AlcType getAlcType() {
        return alcType;
    }

    public void setAlcType(AlcType alcType) {
        this.alcType = alcType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }
}
