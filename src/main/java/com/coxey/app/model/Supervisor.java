package com.coxey.app.model;

import java.util.ArrayList;
import java.util.List;

public class Supervisor {
    private int id;
    private String nameSupervisor;
    private DepartmentTitle departmentTitle;
    private List<Employee> employeeList = new ArrayList<>();

    public Supervisor() {
        //this.employeeList = new ArrayList<>();
    }

    public Supervisor(int id, String nameSupervisor, DepartmentTitle departmentTitle, List<Employee> employeeList) {
        this.id = id;
        this.nameSupervisor = nameSupervisor;
        this.departmentTitle = departmentTitle;
        this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSupervisor() {
        return nameSupervisor;
    }

    public void setNameSupervisor(String name) {
        this.nameSupervisor = name;
    }

    public DepartmentTitle getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(DepartmentTitle departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void setEmployeeToSupervisor(Employee employee) {
        employeeList.add(employee);
    }
}