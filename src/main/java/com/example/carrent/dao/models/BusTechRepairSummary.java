package com.example.carrent.dao.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BusTechRepairSummary {

    private String brandName;

    private LocalDateTime releaseDate;

    private Integer carKmage;
    
    private Integer totalRepairs;
    
    private Integer totalPrise;
    
    
}
