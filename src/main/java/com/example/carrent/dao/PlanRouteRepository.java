package com.example.carrent.dao;

import com.example.carrent.dao.models.RouteDatePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PlanRouteRepository extends JpaRepository<RouteDatePlan, Integer> {

    @Query("select planned FROM RouteDatePlan planned WHERE planned.date = :planningDate")
    List<RouteDatePlan> findPlannedOnDate(@Param("planningDate") LocalDate date);

}
