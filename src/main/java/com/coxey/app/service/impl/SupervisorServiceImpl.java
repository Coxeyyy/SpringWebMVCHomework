package com.coxey.app.service.impl;

import com.coxey.app.model.Employee;
import com.coxey.app.model.Supervisor;
import com.coxey.app.repository.SupervisorRepository;
import com.coxey.app.service.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    private final SupervisorRepository supervisorRepository;

    public SupervisorServiceImpl(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public List<Supervisor> getAllSupervisor() {
        return supervisorRepository.getAllSupervisor();
    }

    @Override
    public Supervisor getSupervisorById(int id) {
        return supervisorRepository.getSupervisorById(id);
    }

    @Override
    public List<Employee> getEmployeeByIdSupervisor(int id) {
        return supervisorRepository.getEmployeeByIdSupervisor(id);
    }

    @Override
    public void addSupervisor(Supervisor supervisor) {
        supervisorRepository.addSupervisor(supervisor);
    }

    @Override
    public void addEmployeeToSupervisor(Supervisor supervisor, Employee employee) {
        supervisorRepository.addEmployeeToSupervisor(supervisor, employee);
    }

    @Override
    public void updateSupervisor(Supervisor supervisor, int id) {
        supervisorRepository.updateSupervisor(supervisor, id);
    }

    @Override
    public void deleteSupervisor(int id) {
        supervisorRepository.deleteSupervisor(id);
    }
}
