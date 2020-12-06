package com.alcoproj.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alctype")
public class AlcType {

    @Id
    @Column(name = "alctype_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "name")
    private List<Alcohol> alcoholList;

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

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }
}
