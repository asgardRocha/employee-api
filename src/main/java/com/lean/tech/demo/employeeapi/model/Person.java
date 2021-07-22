package com.lean.tech.demo.employeeapi.model;

import javax.persistence.*;

@Entity
@Table
public class Person {

    @Id
    @Column
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String cellphone;
    @Column
    private String cityName;

    public Person(int id, String firstName, String lastName, String address, String cellphone, String cityName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cellphone = cellphone;
        this.cityName = cityName;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
