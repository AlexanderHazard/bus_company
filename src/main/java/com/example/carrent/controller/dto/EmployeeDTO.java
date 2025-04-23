package com.example.carrent.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {

    private String identityNumber;

    private String firstName;

    private String middleName;

    private String surname;

    private LocalDate birthDate;

    private String address;

    private String personalPhone;

    private String workPhone;

    private Integer categoryId;

    private Integer positionId;

    private LocalDate jobStart;

    private Integer salary;

}
