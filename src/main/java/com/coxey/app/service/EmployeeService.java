package com.coxey.app.service;

import com.coxey.app.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeByIndex(int id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee updatedEmployee, int id);

    void deleteEmployee(int id);
}
