package com.example.carrent.controller.dto;

import lombok.Data;

@Data
public class RouteInfoDTO {

    private Integer number;

    private String startLocation;

    private String endLocation;

    private Integer distance;

    private Integer plannedTimeMin;

    private Integer tripsPerDay;

}
