package com.example.carrent.dao.models;

import lombok.Data;

@Data
public class EmployeeWorkSummary {

    public EmployeeWorkSummary(Integer employeeId, String identityNumber, String employeeName, String employeeSurname, Long totalWorkedRoutes) {
        this.employeeId = employeeId;
        this.identityNumber = identityNumber;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.totalWorkedRoutes = totalWorkedRoutes;
    }

    private Integer employeeId;
    
    private String identityNumber;
    
    private String employeeName;
    
    private String employeeSurname;
    
    private Long totalWorkedRoutes;
    
}
