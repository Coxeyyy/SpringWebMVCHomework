package com.coxey.app.controller;

import com.coxey.app.model.DepartmentTitle;
import com.coxey.app.model.Employee;
import com.coxey.app.model.JobTitle;
import com.coxey.app.model.Supervisor;
import com.coxey.app.service.EmployeeService;
import com.coxey.app.service.SupervisorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

    private final EmployeeService employeeService;
    private final SupervisorService supervisorService;

    public SupervisorController(EmployeeService employeeService, SupervisorService supervisorService) {
        this.employeeService = employeeService;
        this.supervisorService = supervisorService;
    }

    @GetMapping()
    public String showAllSupervisor(Model model) {
        model.addAttribute("supervisor", supervisorService.getAllSupervisor());
        return "supervisor/allSupervisor";
    }

    @GetMapping("/{id}")
    public String showEmployeeById(Model model, @PathVariable("id") int id) {
        model.addAttribute("supervisor", supervisorService.getSupervisorById(id));
        model.addAttribute("employee", supervisorService.getEmployeeByIdSupervisor(id));
        return "supervisor/showByIndex";
    }

    @GetMapping("/new")
    public String newSupervisor(Model model) {
        model.addAttribute("supervisor", new Supervisor());
        model.addAttribute("departmentsTitles", DepartmentTitle.values());
        return "supervisor/new";
    }

    @GetMapping("/addEmployeeToSupervisor")
    public String test(@ModelAttribute("supervisor") Supervisor supervisor, Model model) {
        Employee employee = new Employee();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("jobTitles", JobTitle.values());
        model.addAttribute("employee1", employee1);
        model.addAttribute("jobTitles1", JobTitle.values());
        model.addAttribute("employee2", employee2);
        model.addAttribute("jobTitles2", JobTitle.values());
        model.addAttribute("supervisor", supervisor);
        return "supervisor/addEmployeeToSupervisor";
    }

    @PostMapping("/addEmployeeToSupervisor")
    public String addEmployeeToSupervisor(@ModelAttribute("employee") Employee employee, @ModelAttribute("employee1") Employee employee1,
                                          @ModelAttribute("employee2") Employee employee2, @ModelAttribute("supervisor") Supervisor supervisor) {
        employeeService.addEmployee(employee);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        supervisorService.addEmployeeToSupervisor(supervisor, employee);
        supervisorService.addEmployeeToSupervisor(supervisor, employee1);
        supervisorService.addEmployeeToSupervisor(supervisor, employee2);
        supervisorService.addSupervisor(supervisor);
        return "redirect:/supervisor";
    }

    @GetMapping("/{id}/edit")
    public String editSupervisor(Model model, @PathVariable("id") int id) {
        model.addAttribute("supervisor", supervisorService.getSupervisorById(id));
        model.addAttribute("departmentsTitles", DepartmentTitle.values());
        model.addAttribute("employee", new Employee());
        model.addAttribute("jobTitles", JobTitle.values());
        return "supervisor/editSupervisor";
    }

    @PatchMapping("/{id}")
    public String updateSupervisor(@ModelAttribute("supervisor") Supervisor supervisor, @PathVariable("id") int id) {
        supervisorService.updateSupervisor(supervisor, id);
        return "redirect:/supervisor";
    }

    @DeleteMapping("/{id}")
    public String deleteSupervisor(@PathVariable("id") int id) {
        supervisorService.deleteSupervisor(id);
        return "redirect:/supervisor";
    }
}
