package com.lean.tech.demo.employeeapi.model;

import java.util.List;

public class PositionView {

    private int positionId;
    private String name;
    private List<EmployeeView> employees;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeView> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeView> employees) {
        this.employees = employees;
    }
}
