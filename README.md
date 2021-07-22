###Create or Update Employee
#####POST
http://localhost:8080/employee
```
{
    "employeeId": 1,
    "person": {
        "personId": 1,
        "firstName": "Asgard",
        "lastName": "Rocha",
        "address": "arbide",
        "cellphone": "4773006085",
        "cityName": "leon"
    },
    "position": {
        "positionId": 1,
        "name": "dev"
    },
    "salary": 1000.2
}
```

##Delete Employee
#####DELETE
http://localhost:8080/employee/{emplyeeId}

##Get Employees
#####GET
http://localhost:8080/employee
##Get Employees filter by name
#####GET
http://localhost:8080/employee?name=employeeName
##Get Employees filter by position
#####GET
http://localhost:8080/employee?position=positionName

###Connect to DB console
http://localhost:8080/h2-console
```
JDBC URL: jdbc:h2:mem:employee_data
User Name: lean
Password: T3ch.
```
 