package com.lean.tech.demo.employeeapi.mapper;

import com.lean.tech.demo.employeeapi.model.*;

import java.util.ArrayList;
import java.util.List;

public class PositionMapper {

    public PositionView getView(Position position, List<Employee> employees) {
        PositionView view = new PositionView();
        view.setPositionId(position.getId());
        view.setName(position.getName());
        List<EmployeeView> employeeViewList = new ArrayList<>();
        for (Employee employee : employees) {
            employeeViewList.add(getEmployeeView(employee));
        }
        view.setEmployees(employeeViewList);
        return view;
    }

    private EmployeeView getEmployeeView(Employee employee) {
        EmployeeView view = new EmployeeView();
        view.setId(employee.getId());
        view.setSalary(employee.getSalary());
        view.setPerson(getPersonView(employee.getPerson()));
        return view;
    }

    private PersonView getPersonView(Person person) {
        PersonView view = new PersonView();
        view.setFirstName(person.getFirstName());
        view.setLastName(person.getLastName());
        view.setAddress(person.getAddress());
        view.setCellphone(person.getCellphone());
        view.setCityName(person.getCityName());
        return view;
    }
}
