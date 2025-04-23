package com.example.carrent.dao;

import com.example.carrent.dao.models.RouteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface RouteInfoRepository extends JpaRepository<RouteInfo, Integer> {

    @Query("SELECT route from RouteInfo route " +
            "WHERE route.id NOT IN (SELECT planned.routeInfoId FROM RouteDatePlan planned where planned.date = :planningDate)")
    List<RouteInfo> findNotPlannedOnDate(@Param("planningDate") LocalDate date);
}
