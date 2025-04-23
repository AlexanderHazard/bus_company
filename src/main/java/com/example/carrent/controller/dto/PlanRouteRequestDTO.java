package com.example.carrent.controller.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PlanRouteRequestDTO {

    private Integer routeInfoId;

    private Integer busId;

    private LocalDate date;

    private Integer plannedTrips;

    private Integer plannedIncome;

}
