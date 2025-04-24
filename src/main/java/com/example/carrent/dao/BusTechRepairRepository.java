package com.example.carrent.dao;

import com.example.carrent.dao.models.BusTechRepair;
import com.example.carrent.dao.models.BusTechRepairSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BusTechRepairRepository extends JpaRepository<BusTechRepair, Integer> {
    
    @Query("SELECT techRepair FROM BusTechRepair techRepair " +
            "WHERE techRepair.startDate >= :date AND techRepair.endDate IS NULL")
    List<BusTechRepair> findAllGoingOnDate(@Param("date") LocalDate date);

    @Query("SELECT techRepair FROM BusTechRepair techRepair " +
            "WHERE techRepair.startDate >= :date AND (techRepair.endDate <= :date OR techRepair.endDate IS NULL)")
    List<BusTechRepair> findAllOnDate(@Param("date") LocalDate date);

    @Query("SELECT techRepair.bus.brandName AS brandName, techRepair.bus.releaseDate AS releaseDate, techRepair.bus.carKmage AS carKmage, COUNT(techRepair.id) AS totalRepairs, SUM(techRepair.price) AS totalPrise FROM BusTechRepair techRepair " +
            "WHERE techRepair.busId = :id AND techRepair.startDate <= :startDate AND techRepair.endDate >= :endDate " +
            "GROUP BY techRepair.bus.brandName, techRepair.bus.releaseDate, releaseDate, techRepair.bus.carKmage")
    List<BusTechRepairSummary> getSummaryByBusId(@Param("id") Integer id, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    
    @Query("SELECT techRepair.bus.brandName AS brandName, techRepair.bus.releaseDate AS releaseDate, techRepair.bus.carKmage AS carKmage, COUNT(techRepair.id) AS totalRepairs, SUM(techRepair.price) AS totalPrise FROM BusTechRepair techRepair " +
            "WHERE techRepair.bus.brandName = :brand AND techRepair.startDate <= :startDate AND techRepair.endDate >= :endDate " +
            "GROUP BY techRepair.bus.brandName, techRepair.bus.releaseDate, releaseDate, techRepair.bus.carKmage")
    List<BusTechRepairSummary> getSummaryByBusBrand(@Param("brand") String brand);
    
}
