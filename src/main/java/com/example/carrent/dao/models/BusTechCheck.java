package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "bus_tech_check")
@AllArgsConstructor
@NoArgsConstructor
public class BusTechCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bus_id")
    private Integer busId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id", insertable = false, updatable = false)
    private Bus bus;

    @Column(name = "check_date")
    private LocalDate date;

    @Column(name = "summary")
    private String summary;
}
