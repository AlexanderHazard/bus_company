package com.example.carrent.dao;

import com.example.carrent.dao.models.EmployeeWorkSummary;
import com.example.carrent.dao.models.RouteBusSummary;
import com.example.carrent.dao.models.RouteDatePlan;
import com.example.carrent.dao.models.RouteDatePlanSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PlanRouteRepository extends JpaRepository<RouteDatePlan, Integer> {

    @Query("SELECT planned FROM RouteDatePlan planned WHERE planned.date = :planningDate")
    List<RouteDatePlan> findPlannedOnDate(@Param("planningDate") LocalDate date);

    @Query("SELECT planned.route.number AS routeNumber, COUNT(planned.busId) AS busCount FROM RouteDatePlan planned " +
            "WHERE planned.date = :planningDate " +
            "GROUP BY planned.route.number")
    List<RouteDatePlanSummary> getSummariesByDate(@Param("planningDate") LocalDate date);

    @Query("SELECT planned.route.number AS routeNumber, planned.bus.inventoryNumber AS busInventoryNumber, SUM(planned.actualTrips) FROM RouteDatePlan planned " +
            "WHERE planned.date >= :startDate AND planned.date <= :endDate " +
            "GROUP BY planned.route.number, planned.bus.inventoryNumber")
    List<RouteBusSummary> getMonthlySummaryForEachBus(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    
    @Query("SELECT employee.id AS employeeId, employee.persona.identityNumber AS identityNumber, employee.persona.firstName AS employeeName, employee.persona.surname AS employeeSurname, SUM(planned.id) AS totalWorkedRoutes FROM RouteDatePlan planned " +
            "JOIN planned.bus bus " +
            "JOIN bus.employees employee " +
            "WHERE planned.date >= :startDate AND planned.date <= :endDate " +
            "GROUP BY employeeId, identityNumber, employeeName, employeeSurname")
    List<EmployeeWorkSummary> findEmployeeWorkSummariesByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    

}
