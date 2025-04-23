package com.example.carrent.dao;

import com.example.carrent.dao.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
