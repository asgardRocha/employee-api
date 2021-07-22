package com.lean.tech.demo.employeeapi.repository;

import com.lean.tech.demo.employeeapi.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> { }
