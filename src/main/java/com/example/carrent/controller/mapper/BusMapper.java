package com.example.carrent.controller.mapper;

import com.example.carrent.controller.dto.BusDTO;
import com.example.carrent.dao.models.Bus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusMapper {

    static BusMapper INSTANCE = Mappers.getMapper(BusMapper.class);

     Bus toBus(BusDTO busDTO);

     BusDTO toBusDTO(Bus bus);

}
