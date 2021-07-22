package com.lean.tech.demo.employeeapi.model;

import javax.persistence.*;

@Entity
@Table
public class Position {

    @Id
    @Column
    private int id;
    @Column
    private String name;

    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Position() {
    }

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
