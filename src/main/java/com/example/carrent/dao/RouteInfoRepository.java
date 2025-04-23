package com.example.carrent.dao;

import com.example.carrent.dao.models.RouteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteInfoRepository extends JpaRepository<RouteInfo, Integer> {
}
