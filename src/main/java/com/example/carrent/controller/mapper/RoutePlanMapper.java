package com.example.carrent.controller.mapper;


import com.example.carrent.controller.dto.PlanRouteRequestDTO;
import com.example.carrent.dao.models.RouteDatePlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoutePlanMapper {

    RoutePlanMapper INSTANCE = Mappers.getMapper(RoutePlanMapper.class);

    RouteDatePlan toRouteDatePlan(PlanRouteRequestDTO planRouteRequestDTO);
}
