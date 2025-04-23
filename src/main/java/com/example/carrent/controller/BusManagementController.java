package com.example.carrent.controller;

import com.example.carrent.controller.dto.BusDTO;
import com.example.carrent.controller.mapper.BusMapper;
import com.example.carrent.dao.BusRepository;
import com.example.carrent.dao.models.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "/busmanager")
public class BusManagementController {

    @Autowired
    private BusRepository busRepository;

    @GetMapping("/busmanager/allBuses")
    public String getAllCars(Model model) {
        List<Bus> buses = busRepository.findAll();
        model.addAttribute("buses", buses);
        model.addAttribute("deleteBus", new BusDTO());
        return "buses";
    }

    @GetMapping("/busmanager/addBus")
    public String addCar(Model model) {
        model.addAttribute("bus", new BusDTO());
        return "addBus";
    }

    @PostMapping("/busmanager/addBus")
    public String insertCar(@ModelAttribute BusDTO busDTO) {
        Bus bus = BusMapper.INSTANCE.toBus(busDTO);
        busRepository.save(bus);
        return "redirect:/busmanager/allBuses";
    }

    @PostMapping("/busmanager/deleteBus")
    public String deleteCar(@RequestParam(value = "id") Integer id) {
        busRepository.deleteById(id);
        return "redirect:/busmanager/allBuses";
    }

}
