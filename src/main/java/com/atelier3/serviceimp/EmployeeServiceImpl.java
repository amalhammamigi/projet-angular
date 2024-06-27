package com.atelier3.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atelier3.model.Employee;
import com.atelier3.repository.EmployeeRepository;
import com.atelier3.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public Employee updateEmployee(Integer employeeId, Employee employeeDetails) {
        return employeeRepository.findById(employeeId)
                .map(employee -> {
                    employee.setName(employeeDetails.getName());
                    employee.setEmail(employeeDetails.getEmail());
                    employee.setPhone(employeeDetails.getPhone());
                    employee.setDepartment(employeeDetails.getDepartment());
                    return employeeRepository.save(employee);
                })
                .orElseThrow(() -> new RuntimeException("Employee not found with id " + employeeId));
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.findById(employeeId)
                .ifPresent(employee -> employeeRepository.delete(employee));
    }
}