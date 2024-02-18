package com.coxey.app.repository;

import com.coxey.app.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {

    List<Employee> getAllEmployees();

    Employee getEmployeeByIndex(int id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee updatedEmployee, int id);

    void deleteEmployee(int id);
}
