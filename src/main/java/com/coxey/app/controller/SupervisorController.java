package com.coxey.app.controller;

import com.coxey.app.model.DepartmentTitle;
import com.coxey.app.model.Employee;
import com.coxey.app.model.JobTitle;
import com.coxey.app.model.Supervisor;
import com.coxey.app.service.EmployeeService;
import com.coxey.app.service.SupervisorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
    public String showSupervisorById(Model model, @PathVariable("id") int id) {
        model.addAttribute("supervisor", supervisorService.getSupervisorById(id));
        model.addAttribute("employee", supervisorService.getEmployeeByIdSupervisor(id));
        return "supervisor/showByIndex";
    }

    @GetMapping("/new")
    public String newSupervisor(Model model) {
        model.addAttribute("supervisor", new Supervisor());
        model.addAttribute("departmentsTitles", DepartmentTitle.values());
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "supervisor/new";
    }

    @PostMapping("/new")
    public String addEmployeeToSupervisor(@RequestParam("employeeId") List<Integer> listEmployeeSelectedId, @ModelAttribute("supervisor") Supervisor supervisor) {
        List<Employee> listEmployee = new ArrayList<>();
        for(int i = 0; i < listEmployeeSelectedId.size(); i++) {
            listEmployee.add(employeeService.getEmployeeByIndex(listEmployeeSelectedId.get(i)));
        }
        supervisor.setEmployeeList(listEmployee);
        supervisorService.addSupervisor(supervisor);
        return "redirect:/supervisor";
    }

    @GetMapping("/{id}/edit")
    public String editSupervisor(Model model, @PathVariable("id") int id) {
        model.addAttribute("supervisor", supervisorService.getSupervisorById(id));
        model.addAttribute("departmentsTitles", DepartmentTitle.values());
        model.addAttribute("employee", employeeService.getAllEmployees());
        model.addAttribute("jobTitles", JobTitle.values());
        return "supervisor/editSupervisor";
    }

    @PatchMapping("/{id}")
    public String updateSupervisor(@ModelAttribute("supervisor") Supervisor supervisor, @PathVariable("id") int id,
                                   @RequestParam("employeeId") List<Integer> listEmployeeSelectedId) {
        List<Employee> listEmployee = new ArrayList<>();
        for(int i = 0; i < listEmployeeSelectedId.size(); i++) {
            listEmployee.add(employeeService.getEmployeeByIndex(listEmployeeSelectedId.get(i)));
        }
        supervisor.setEmployeeList(listEmployee);
        supervisorService.updateSupervisor(supervisor, id);
        return "redirect:/supervisor";
    }

    @DeleteMapping("/{id}")
    public String deleteSupervisor(@PathVariable("id") int id) {
        supervisorService.deleteSupervisor(id);
        return "redirect:/supervisor";
    }
}
