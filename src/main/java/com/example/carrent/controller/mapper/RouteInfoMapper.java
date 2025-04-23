package com.example.carrent.controller.mapper;

import com.example.carrent.controller.dto.RouteInfoDTO;
import com.example.carrent.dao.models.RouteInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteInfoMapper {

    static RouteInfoMapper INSTANCE = Mappers.getMapper(RouteInfoMapper.class);

     RouteInfo toRouteInfo(RouteInfoDTO routeInfoDTO);

     RouteInfoDTO toRouteInfoDTO(RouteInfo routeInfo);

}
