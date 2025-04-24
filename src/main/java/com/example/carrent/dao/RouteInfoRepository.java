package com.example.carrent.dao;

import com.example.carrent.dao.models.RouteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RouteInfoRepository extends JpaRepository<RouteInfo, Integer> {

    @Query("SELECT route from RouteInfo route " +
            "WHERE route.tripsPerDay <= (SELECT SUM (planned.plannedTrips) FROM RouteDatePlan planned WHERE planned.routeInfoId = route.id AND planned.date = :planningDate)")
    List<RouteInfo> findNotFullyPlannedOnDate(@Param("planningDate") LocalDate date);
}
