package com.coxey.app.repository.impl;

import com.coxey.app.db.Database;
import com.coxey.app.model.Employee;
import com.coxey.app.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public List<Employee> getAllEmployees() {
        return Database.employeeList;
    }

    @Override
    public Employee getEmployeeByIndex(int id) {
        return Database.employeeList.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setId(++Database.ID_EMPLOYEE);
        Database.employeeList.add(employee);
    }

    @Override
    public void updateEmployee(Employee updatedEmployee, int id) {
        Employee employee = getEmployeeByIndex(id);
        employee.setName(updatedEmployee.getName());
        employee.setJobTitle(updatedEmployee.getJobTitle());
    }

    @Override
    public void deleteEmployee(int id) {
        Database.employeeList.removeIf(employee -> employee.getId() == id);
    }
}
