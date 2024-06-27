package com.atelier3.service;

import java.util.List;
import java.util.Optional;

import com.atelier3.model.Employee;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Integer employeeId);
    Employee updateEmployee(Integer employeeId, Employee employeeDetails);
    void deleteEmployee(Integer employeeId);
}