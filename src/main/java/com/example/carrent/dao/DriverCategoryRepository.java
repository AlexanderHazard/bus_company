package com.example.carrent.dao;

import com.example.carrent.dao.models.DriverCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverCategoryRepository extends JpaRepository<DriverCategory, Integer> {
}
