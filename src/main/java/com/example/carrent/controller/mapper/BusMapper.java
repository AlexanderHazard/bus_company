package com.example.carrent.controller.mapper;

import com.example.carrent.controller.dto.BusDTO;
import com.example.carrent.dao.models.Bus;

public class BusMapper {

    public static Bus toBus(BusDTO busDTO){
        Bus bus = new Bus();
        bus.setBrandName(busDTO.getBrandName());
        bus.setInventoryNumber(busDTO.getInventoryNumber());
        bus.setCarNumber(busDTO.getCarNumber());
        bus.setCarKmage(busDTO.getCarKmage());
        bus.setReleaseDate(busDTO.getReleaseDate());
        return bus;
    }

}
