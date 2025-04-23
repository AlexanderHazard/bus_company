package com.example.carrent.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BusDTO {

    private Integer id;

    private String brandName;

    private LocalDateTime releaseDate;

    private String inventoryNumber;

    private String carNumber;

    private Integer carKmage;

}
