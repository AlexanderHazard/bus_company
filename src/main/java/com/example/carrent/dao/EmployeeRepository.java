package com.example.carrent.dao;

import com.example.carrent.dao.models.Employee;
import com.example.carrent.dao.models.EmployeeWorkSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
