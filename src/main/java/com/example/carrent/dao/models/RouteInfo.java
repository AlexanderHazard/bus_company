package com.example.carrent.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "route_info")
@AllArgsConstructor
@NoArgsConstructor
public class RouteInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_info_seq_gen")
    @SequenceGenerator(
            name = "route_info_seq_gen",
            sequenceName = "route_info_id_seq",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "route_number")
    private Integer number;

    @Column(name = "route_start_location")
    private String startLocation;

    @Column(name = "route_end_location")
    private String endLocation;

    @Column(name = "route_distance")
    private Integer distance;

    @Column(name = "planned_time_min")
    private Integer plannedTimeMin;

    @Column(name = "trips_per_day")
    private Integer tripsPerDay;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_info_id", insertable = false , updatable = false)
    private List<RouteDatePlan> routeDatePlans;

}
