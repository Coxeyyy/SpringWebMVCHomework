package com.coxey.app.repository;

import com.coxey.app.model.Employee;
import com.coxey.app.model.Supervisor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupervisorRepository {

    List<Supervisor> getAllSupervisor();

    Supervisor getSupervisorById(int id);

    List<Employee> getEmployeeByIdSupervisor(int id);

    void addSupervisor(Supervisor supervisor);

    void addEmployeeToSupervisor(Supervisor supervisor, Employee employee);

    void updateSupervisor(Supervisor supervisor, int id);

    void deleteSupervisor(int id);
}
