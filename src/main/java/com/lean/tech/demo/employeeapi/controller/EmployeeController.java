package com.lean.tech.demo.employeeapi.controller;

import com.lean.tech.demo.employeeapi.model.Employee;
import com.lean.tech.demo.employeeapi.service.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeInterface employeeService;

    @GetMapping("/employee")
    private List<Employee> getAllBy(@RequestParam("name") Optional<String> name, @RequestParam("position") Optional<String> position) {
        return employeeService.getAll(name, position);
    }

    @PostMapping("/employee")
    private void saveEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping("/employee/{employeeId}")
    private void deleteEmployee(@PathVariable("employeeId") int employeeId) {
        employeeService.delete(employeeId);
    }


}
