package com.lean.tech.demo.employeeapi.service;

import com.lean.tech.demo.employeeapi.model.Employee;
import com.lean.tech.demo.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeInterface {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void delete(int employeeId) {
        repository.deleteById(employeeId);
    }

    @Override
    public List<Employee> getAll(Optional<String> optionalName, Optional<String> optionalPosition) {
        List<Employee> employees = new ArrayList<>();
        repository.findAll().forEach(employees::add);
        if (optionalName.isPresent()) {
            employees = employees.stream().
                    filter(employee ->
                            employee.getPerson().getFirstName().equalsIgnoreCase(optionalName.get())
                    ).collect(Collectors.toList());
        }
        if (optionalPosition.isPresent()) {
            employees = employees.stream().
                    filter(employee ->
                            employee.getPosition().getName().equalsIgnoreCase(optionalPosition.get())
                    ).collect(Collectors.toList());
        }
        return employees;
    }

}
