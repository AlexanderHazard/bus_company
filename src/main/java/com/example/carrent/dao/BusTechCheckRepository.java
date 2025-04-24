package com.example.carrent.dao;

import com.example.carrent.dao.models.BusTechCheck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BusTechCheckRepository extends JpaRepository<BusTechCheck, Integer> {
    
    @Query("SELECT techCheck FROM BusTechCheck techCheck " +
            "WHERE techCheck.date = :date AND techCheck.summary IS NULL")
    List<BusTechCheck> findAllNotClosedOnDate(@Param("date") LocalDate date);

    @Query("SELECT techCheck from BusTechCheck techCheck " +
            "WHERE techCheck.date = :date")
    List<BusTechCheck> findAllOnDate(@Param("date") LocalDate date);
    
    @Query("UPDATE BusTechCheck techCheck SET techCheck.summary = :summary WHERE techCheck.id = :id")
    void updateSummary(@Param("id") Integer id, @Param("summary") String summary);
    
}
