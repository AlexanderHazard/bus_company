package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "route_date_plan")
@AllArgsConstructor
@NoArgsConstructor
public class RouteDatePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "route_info_id")
    private Integer routeInfoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_info_id", insertable = false, updatable = false)
    private RouteInfo route;

    @Column(name = "bus_id")
    private Integer busId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bus_id", insertable = false, updatable = false)
    private Bus bus;

    @Column(name = "route_date")
    private LocalDate date;

    @Column(name = "total_trips")
    private Integer totalTrips;

    @Column(name = "planned_income")
    private Integer plannedIncome;

    @Column(name = "actual_income")
    private Integer actualIncome;

}
