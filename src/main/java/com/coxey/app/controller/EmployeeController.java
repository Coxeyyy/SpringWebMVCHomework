package com.coxey.app.controller;

import com.coxey.app.model.Employee;
import com.coxey.app.model.JobTitle;
import com.coxey.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public String showAllEmployee(Model model) {
        model.addAttribute("employee", employeeService.getAllEmployees());
        return "employee/allEmployee";
    }

    @GetMapping("/{id}")
    public String showEmployeeById(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeService.getEmployeeByIndex(id));
        return "employee/showByIndex";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("jobTitles", JobTitle.values());
        return "employee/new";
    }

    @PostMapping()
    public String createEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}/edit")
    public String editEmployee(Model model, @PathVariable("id") int id) {
        model.addAttribute("employee", employeeService.getEmployeeByIndex(id));
        model.addAttribute("jobTitles", JobTitle.values());
        return "employee/editEmployee";
    }

    @PatchMapping("/{id}")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, @PathVariable("id") int id) {
        employeeService.updateEmployee(employee, id);
        return "redirect:/employee";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
