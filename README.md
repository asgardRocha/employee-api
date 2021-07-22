# Employee API

Employee API demo

## Requirements

Java 8

Maven

## Usage

### Create & Update Employee

POST http://localhost:8080/employee
```
{
    "id": 1,
    "person": {
        "id": 1,
        "firstName": "John",
        "lastName": "Snow",
        "address": "in a cold place",
        "cellphone": "12334456",
        "cityName": "Winterfell"
    },
    "position": {
        "id": 1,
        "name": "dev"
    },
    "salary": 1000.2
}
```

### Delete Employee

DELETE http://localhost:8080/employee/{emplyeeId}

### Get Employees
#### Get- All Employees

GET http://localhost:8080/employee

#### Get- Employees filter by name

GET http://localhost:8080/employee?name=employeeName

#### Get- Employees filter by position

GET http://localhost:8080/employee?position=positionName

### Get Positions

GET http://localhost:8080/positions

## Connect to DB console
http://localhost:8080/h2-console
```
JDBC URL: jdbc:h2:mem:employee_data
User Name: lean
Password: T3ch.
```
 