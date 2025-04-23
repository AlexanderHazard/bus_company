package com.example.carrent.controller;

import com.example.carrent.controller.dto.EmployeeDTO;
import com.example.carrent.controller.mapper.EmployeeMapper;
import com.example.carrent.dao.EmployeeRepository;
import com.example.carrent.dao.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller(value = "/manager")
public class ManagerController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/manager/allEmployees")
    public String getAllEmployee(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("deleteBus", new EmployeeDTO());
        return "employees";
    }

    @GetMapping("/manager/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "addEmployee";
    }

    @PostMapping("/manager/addEmployee")
    public String insertEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);
        employeeRepository.save(employee);
        return "redirect:/manager/allEmployees";
    }

}
