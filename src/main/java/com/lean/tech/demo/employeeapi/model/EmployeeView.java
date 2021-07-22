package com.lean.tech.demo.employeeapi.model;


public class EmployeeView {
    private int id;
    private PersonView person;
    private double salary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonView getPerson() {
        return person;
    }

    public void setPerson(PersonView person) {
        this.person = person;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
