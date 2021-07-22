package com.lean.tech.demo.employeeapi.service;

import com.lean.tech.demo.employeeapi.mapper.PositionMapper;
import com.lean.tech.demo.employeeapi.model.Employee;
import com.lean.tech.demo.employeeapi.model.PositionView;
import com.lean.tech.demo.employeeapi.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PositionService implements PositionInterface {

    @Autowired
    private PositionRepository repository;

    @Autowired
    private EmployeeInterface employeeInterface;

    private PositionMapper mapper = new PositionMapper();

    @Override
    public List<PositionView> getAllPositions() {
        List<PositionView> views = new ArrayList<>();
        repository.findAll().forEach(position -> {
            List<Employee> employees = employeeInterface.getAll(Optional.empty(), Optional.of(position.getName()));
            views.add(mapper.getPositionView(position, employees));
        });
        return views;
    }
}
