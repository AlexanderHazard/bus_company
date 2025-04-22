package com.example.carrent.controller.mapper;

import com.example.carrent.controller.dto.BusDTO;
import com.example.carrent.controller.dto.RouteInfoDTO;
import com.example.carrent.dao.models.Bus;
import com.example.carrent.dao.models.RouteInfo;

public class RouteInfoMapper {

    public static RouteInfo toRouteInfo(RouteInfoDTO routeInfoDTO){
        RouteInfo routeInfo = new RouteInfo();
        routeInfo.setNumber(routeInfoDTO.getNumber());
        routeInfo.setStartLocation(routeInfoDTO.getStartLocation());
        routeInfo.setEndLocation(routeInfoDTO.getEndLocation());
        routeInfo.setDistance(routeInfoDTO.getDistance());
        routeInfo.setTripsPerDay(routeInfoDTO.getTripsPerDay());
        routeInfo.setPlannedTimeMin(routeInfoDTO.getPlannedTimeMin());
        return routeInfo;
    }

}
