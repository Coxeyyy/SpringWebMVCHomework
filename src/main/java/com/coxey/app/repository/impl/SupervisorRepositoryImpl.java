package com.coxey.app.repository.impl;

import com.coxey.app.db.Database;
import com.coxey.app.model.Employee;
import com.coxey.app.model.Supervisor;
import com.coxey.app.repository.SupervisorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupervisorRepositoryImpl implements SupervisorRepository {
    @Override
    public List<Supervisor> getAllSupervisor() {
        return Database.supervisorList;
    }

    @Override
    public Supervisor getSupervisorById(int id) {
        return Database.supervisorList.stream()
                .filter(supervisor -> supervisor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> getEmployeeByIdSupervisor(int id) {
        return Database.supervisorList.stream()
                .filter(supervisor -> supervisor.getId() == id)
                .findFirst()
                .map(Supervisor::getEmployeeList)
                .orElse(null);
    }

    @Override
    public void addSupervisor(Supervisor supervisor) {
        supervisor.setId(++Database.ID_SUPERVISOR);
        Database.supervisorList.add(supervisor);
    }

    @Override
    public void addEmployeeToSupervisor(Supervisor supervisor, Employee employee) {
        supervisor.setEmployeeToSupervisor(employee);
    }

    @Override
    public void updateSupervisor(Supervisor supervisor, int id) {
        Supervisor supervisor1 = getSupervisorById(id);
        supervisor1.setNameSupervisor(supervisor.getNameSupervisor());
        supervisor1.setDepartmentTitle(supervisor.getDepartmentTitle());
        supervisor1.setEmployeeList(supervisor.getEmployeeList());
    }

    @Override
    public void deleteSupervisor(int id) {
        Database.supervisorList.removeIf(supervisor -> supervisor.getId() == id);
    }
}
