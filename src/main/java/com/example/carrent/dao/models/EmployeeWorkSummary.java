package com.example.carrent.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWorkSummary {

    private Integer employeeId;
    
    private String identityNumber;
    
    private String employeeName;
    
    private String employeeSurname;
    
    private Long totalWorkedRoutes;
    
}
