package com.lean.tech.demo.employeeapi.service;

import com.lean.tech.demo.employeeapi.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeInterface {

    void save(Employee employee);

    void delete(int employeeId);

    List<Employee> getAll(Optional<String> name, Optional<String> position);
}
