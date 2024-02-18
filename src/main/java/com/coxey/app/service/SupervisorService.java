package com.coxey.app.service;

import com.coxey.app.model.Employee;
import com.coxey.app.model.Supervisor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupervisorService {

    List<Supervisor> getAllSupervisor();

    Supervisor getSupervisorById(int id);

    List<Employee> getEmployeeByIdSupervisor(int id);

    void addSupervisor(Supervisor supervisor);

    void addEmployeeToSupervisor(Supervisor supervisor, Employee employee);

    void updateSupervisor(Supervisor supervisor, int id);

    void deleteSupervisor(int id);
}
