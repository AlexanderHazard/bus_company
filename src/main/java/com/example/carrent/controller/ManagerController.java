package com.example.carrent.controller;

import com.example.carrent.controller.dto.EmployeeDTO;
import com.example.carrent.controller.mapper.EmployeeMapper;
import com.example.carrent.dao.DriverCategoryRepository;
import com.example.carrent.dao.EmployeeRepository;
import com.example.carrent.dao.PlanRouteRepository;
import com.example.carrent.dao.PositionRepository;
import com.example.carrent.dao.models.Employee;
import com.example.carrent.dao.models.EmployeeWorkSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Controller(value = "/manager")
public class ManagerController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DriverCategoryRepository driverCategoryRepository;

    @Autowired
    private PositionRepository positionRepository;
    
    @Autowired
    private PlanRouteRepository planRouteRepository;

    @GetMapping("/manager/allEmployees")
    public String getAllEmployee(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("deleteBus", new EmployeeDTO());
        return "employees";
    }

    @GetMapping("/manager/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("positions", positionRepository.findAll());
        model.addAttribute("driverCategories", driverCategoryRepository.findAll());
        model.addAttribute("employee", new EmployeeDTO());
        return "addEmployee";
    }

    @PostMapping("/manager/addEmployee")
    public String insertEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.toEmployee(employeeDTO);
        employeeRepository.save(employee);
        return "redirect:/manager/allEmployees";
    }

    @GetMapping("/manager/employeeWorkSummary")
    public String employeeSummary(
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(value = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            Model model) {

        List<EmployeeWorkSummary> employeeWorkSummaries = startDate != null && endDate != null
                ? planRouteRepository.findEmployeeWorkSummariesByDate(startDate, endDate)
                : Collections.emptyList();

        model.addAttribute("employees", employeeWorkSummaries);

        return "employeesWorkSummary";
    }

}
