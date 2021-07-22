package com.lean.tech.demo.employeeapi.service;

import com.lean.tech.demo.employeeapi.model.Employee;
import com.lean.tech.demo.employeeapi.model.Person;
import com.lean.tech.demo.employeeapi.model.Position;
import com.lean.tech.demo.employeeapi.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private static EmployeeService service;
    @Mock
    private EmployeeRepository repository;

    private static List<Employee> employees;

    @BeforeAll
    public static void setUp() {
        employees = new ArrayList<>();
        employees.add(getEmployeeByName(1, 1, "Robb", "young wolf"));
        employees.add(getEmployeeByName(2, 2, "Sansa", "the queen in the north"));
    }

    private static Employee getEmployeeByName(int employeeId, int personId, String name, String positionName) {
        Employee employee = new Employee();
        employee.setId(employeeId);
        employee.setSalary(10);
        Position position = new Position(1, positionName);
        employee.setPosition(position);
        Person person = new Person(personId, name, "Stark", "some address", "1234567", "Winterfell");
        employee.setPerson(person);
        return employee;
    }

    @Test
    void testSaveMethodCallRepositoryOnce() {
        Employee employee = getEmployeeByName(1, 1, "Robb", "young wolf");
        service.save(employee);
        verify(repository, times(1)).save(employee);
    }

    @Test
    void testDeleteMethodCallRepositoryOnce() {
        service.delete(1);
        verify(repository, times(1)).deleteById(1);
    }

    @Test
    void testGetAllWithoutFilter() {
        when(repository.findAll()).thenReturn(employees);
        List<Employee> testEmployees = service.getAll(Optional.empty(), Optional.empty());
        assertTrue(testEmployees.size() == 2);
    }

    @Test
    void testGetAllFilterByName() {
        when(repository.findAll()).thenReturn(employees);
        List<Employee> testEmployees = service.getAll(Optional.of("Robb"), Optional.empty());
        assertTrue(testEmployees.size() == 1);
        assertTrue(testEmployees.get(0).getPerson().getFirstName().equalsIgnoreCase("Robb"));
    }

    @Test
    void testGetAllFilterByPosition() {
        when(repository.findAll()).thenReturn(employees);
        List<Employee> testEmployees = service.getAll(Optional.empty(), Optional.of("the queen in the north"));
        assertTrue(testEmployees.size() == 1);
        assertTrue(testEmployees.get(0).getPosition().getName().equalsIgnoreCase("the queen in the north"));
    }
}