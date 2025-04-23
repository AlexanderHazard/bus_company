package com.example.carrent.dao;

import com.example.carrent.dao.models.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Integer> {
}
