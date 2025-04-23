package com.example.carrent.dao;

import com.example.carrent.dao.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.RouteMatcher;

import java.time.LocalDate;
import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Integer> {

    @Query("SELECT b from Bus b " +
            "WHERE b.id NOT IN (SELECT planned.busId FROM RouteDatePlan planned where planned.date = :planningDate)")
    List<Bus> findFreeOnDate(@Param("planningDate") LocalDate date);

}
