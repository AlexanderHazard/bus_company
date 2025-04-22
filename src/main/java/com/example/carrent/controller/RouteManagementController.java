package com.example.carrent.controller;

import com.example.carrent.controller.dto.RouteInfoDTO;
import com.example.carrent.controller.mapper.RouteInfoMapper;
import com.example.carrent.dao.RouteInfoRepository;
import com.example.carrent.dao.models.RouteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller(value = "/routemanager")
public class RouteManagementController {

    @Autowired
    private RouteInfoRepository routeInfoRepository;

    @GetMapping("/routemanager/allRouteInfos")
    public String getAllRoutes(Model model) {
        List<RouteInfo> routes = routeInfoRepository.findAll();
        model.addAttribute("routes", routes);
        model.addAttribute("deleteRoute", new RouteInfoDTO());
        return "routeInfos";
    }

    @GetMapping("/routemanager/addRouteInfo")
    public String addRoute(Model model) {
        model.addAttribute("route", new RouteInfoDTO());
        return "addRouteInfo";
    }

    @PostMapping("/routemanager/addRouteInfo")
    public String insertRoute(@ModelAttribute RouteInfoDTO routeInfoDTO) {
        RouteInfo routeInfo = RouteInfoMapper.toRouteInfo(routeInfoDTO);
        routeInfoRepository.save(routeInfo);
        return "redirect:/routemanager/allRouteInfos";
    }

    @PostMapping("/routemanager/deleteRoute")
    public String deleteCar(@RequestParam(value = "id") Integer id) {
        routeInfoRepository.deleteById(id);
        return "redirect:/routemanager/allRouteInfos";
    }

}
