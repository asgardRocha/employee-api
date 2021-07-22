package com.lean.tech.demo.employeeapi.service;

import com.lean.tech.demo.employeeapi.model.Employee;
import com.lean.tech.demo.employeeapi.model.Person;
import com.lean.tech.demo.employeeapi.model.Position;
import com.lean.tech.demo.employeeapi.model.PositionView;
import com.lean.tech.demo.employeeapi.repository.PositionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PositionServiceTest {

    @InjectMocks
    private PositionService service;
    @Mock
    private PositionRepository repository;
    @Mock
    private EmployeeInterface employeeInterface;

    private static List<Employee> employees;

    @BeforeAll
    public static void setUp() {
        employees = new ArrayList<>();
        employees.add(getEmployeeByName(1, 1, "Robb"));
        employees.add(getEmployeeByName(2, 2, "Rob Child"));
    }

    private static Employee getEmployeeByName(int employeeId, int personId, String name) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setSalary(10);
        Position position = new Position(1, "young wolf");
        employee.setPosition(position);
        Person person = new Person(personId, name, "Stark", "some address", "1234567", "Winterfell");
        employee.setPerson(person);
        return employee;
    }

    @Test
    public void testGetAllPositions() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(1, "young wolf"));
        positions.add(new Position(2, "the mad king"));
        when(repository.findAll()).thenReturn(positions);
        when(employeeInterface.getAll(Optional.empty(), Optional.of(positions.get(0).getName()))).thenReturn(employees);
        when(employeeInterface.getAll(Optional.empty(), Optional.of(positions.get(1).getName()))).thenReturn(new ArrayList<>());

        List<PositionView> response = service.getAllPositions();
        assertTrue(response.size() == 2);


    }


}