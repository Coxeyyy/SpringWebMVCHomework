package com.coxey.app.service.impl;

import com.coxey.app.model.Employee;
import com.coxey.app.repository.EmployeeRepository;
import com.coxey.app.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee getEmployeeByIndex(int id) {
        return employeeRepository.getEmployeeByIndex(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee updatedEmployee, int id) {
        employeeRepository.updateEmployee(updatedEmployee, id);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }
}
