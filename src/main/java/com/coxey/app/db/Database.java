package com.coxey.app.db;

import com.coxey.app.model.DepartmentTitle;
import com.coxey.app.model.Employee;
import com.coxey.app.model.JobTitle;
import com.coxey.app.model.Supervisor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Database {

    public static List<Employee> employeeList;

    public static List<Supervisor> supervisorList;

    public static int ID_EMPLOYEE = 0;
    public static int ID_SUPERVISOR = 0;

    static {
        employeeList = new ArrayList<>();
        supervisorList = new ArrayList<>();

        employeeList.add(new Employee(++ID_EMPLOYEE, "Артем", JobTitle.DEVELOPER));
        employeeList.add(new Employee(++ID_EMPLOYEE, "Ivan", JobTitle.ANALYST));
        employeeList.add(new Employee(++ID_EMPLOYEE, "Danil", JobTitle.DEVOPS));

        Employee employee1 = new Employee(++ID_EMPLOYEE, "Vitalik", JobTitle.ANALYST);

        List<Employee> listForSupervisor = new ArrayList<>();
        employeeList.add(employee1);
        listForSupervisor.add(employee1);

        supervisorList.add(new Supervisor(++ID_SUPERVISOR, "Vasya", DepartmentTitle.ANALYSTS, listForSupervisor));
    }
}
