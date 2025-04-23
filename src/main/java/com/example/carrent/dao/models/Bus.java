package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "bus")
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bus_seq_gen")
    @SequenceGenerator(
            name = "bus_seq_gen",
            sequenceName = "bus_id_seq",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "inv_number")
    private String inventoryNumber;

    @Column(name = "car_number")
    private String carNumber;

    @Column(name = "car_kmage")
    private Integer carKmage;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id")
    private List<Employee> employees;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id")
    private List<BusTechCheck> busTechChecks;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id")
    private List<BusTechRepair> busTechRepairs;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id")
    private List<RouteDatePlan> routeDatePlans;

}
