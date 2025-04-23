package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bus_tech_repair")
@AllArgsConstructor
@NoArgsConstructor
public class BusTechRepair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bus_id")
    private Integer busId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id", insertable = false, updatable = false)
    private Bus bus;

    @Column(name = "repair_start_date")
    private LocalDate startDate;

    @Column(name = "repair_end_date")
    private LocalDate endDate;

    @Column(name = "price")
    private Integer price;

    @Column(name = "repair_summary")
    private String summary;
}
