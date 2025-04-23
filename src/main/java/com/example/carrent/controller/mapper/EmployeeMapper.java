package com.example.carrent.controller.mapper;

import com.example.carrent.controller.dto.EmployeeDTO;
import com.example.carrent.dao.models.Employee;
import com.example.carrent.dao.models.Persona;

public class EmployeeMapper {

    public static Employee toEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setJobStart(employeeDTO.getJobStart());
        employee.setSalary(employeeDTO.getSalary());
        employee.setCategotyId(employeeDTO.getCategoryId());
        employee.setPositionId(employeeDTO.getPositionId());

        Persona persona = new Persona();
        persona.setIdentityNumber(employeeDTO.getIdentityNumber());
        persona.setFirstName(employeeDTO.getFirstName());
        persona.setSurname(employeeDTO.getSurname());
        persona.setMiddleName(employeeDTO.getMiddleName());
        persona.setAddress(employeeDTO.getAddress());
        persona.setBirthDate(employeeDTO.getBirthDate());
        persona.setPersonalPhone(employeeDTO.getPersonalPhone());
        persona.setWorkPhone(employeeDTO.getWorkPhone());

        employee.setPersona(persona);

        return employee;
    }
}
