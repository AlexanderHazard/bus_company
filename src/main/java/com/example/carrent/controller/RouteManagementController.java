package com.example.carrent.controller;

import com.example.carrent.controller.dto.BusDTO;
import com.example.carrent.controller.dto.PlanRouteRequestDTO;
import com.example.carrent.controller.dto.RouteInfoDTO;
import com.example.carrent.controller.mapper.BusMapper;
import com.example.carrent.controller.mapper.RouteInfoMapper;
import com.example.carrent.controller.mapper.RoutePlanMapper;
import com.example.carrent.dao.BusRepository;
import com.example.carrent.dao.PlanRouteRepository;
import com.example.carrent.dao.RouteInfoRepository;
import com.example.carrent.dao.models.RouteDatePlan;
import com.example.carrent.dao.models.RouteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller(value = "/routemanager")
public class RouteManagementController {

    @Autowired
    private RouteInfoRepository routeInfoRepository;

    @Autowired
    private PlanRouteRepository planRouteRepository;

    @Autowired
    private BusRepository busRepository;

    @GetMapping("/routemanager/allRouteInfos")
    public String getAllRouteInfos(Model model) {
        List<RouteInfo> routes = routeInfoRepository.findAll();
        model.addAttribute("routes", routes);
        model.addAttribute("deleteRoute", new RouteInfoDTO());
        return "routeInfos";
    }

    @GetMapping("/routemanager/addRouteInfo")
    public String addRouteInfo(Model model) {
        model.addAttribute("route", new RouteInfoDTO());
        return "addRouteInfo";
    }

    @PostMapping("/routemanager/addRouteInfo")
    public String insertRouteInfo(@ModelAttribute RouteInfoDTO routeInfoDTO) {
        RouteInfo routeInfo = RouteInfoMapper.INSTANCE.toRouteInfo(routeInfoDTO);
        routeInfoRepository.save(routeInfo);
        return "redirect:/routemanager/allRouteInfos";
    }

    @PostMapping("/routemanager/deleteRoute")
    public String deleteRouteInfo(@RequestParam(value = "id") Integer id) {
        routeInfoRepository.deleteById(id);
        return "redirect:/routemanager/allRouteInfos";
    }

    @GetMapping("/routemanager/todayPlannedRoutes")
    public String allPlannedRoutes(Model model) {
        return "redirect:/routemanager/plannedRoutes?date=" + LocalDate.now();
    }

    @GetMapping("/routemanager/plannedRoutes")
    public String allPlannedRoutes(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {
        LocalDate searchDate = date == null ? LocalDate.now() : date;
        List<RouteDatePlan> routeDatePlans = planRouteRepository.findPlannedOnDate(searchDate);
        model.addAttribute("date", date);
        model.addAttribute("routes", routeDatePlans);
        return "plannedRoutes";
    }

    @GetMapping("/routemanager/planRoute")
    public String planRoute(Model model) {
        model.addAttribute("plan", new PlanRouteRequestDTO());
        return "routePlanning";
    }

    @PostMapping("/routemanager/planRoute")
    public String planRoute(@ModelAttribute PlanRouteRequestDTO planRouteRequestDTO) {
        RouteDatePlan routeDatePlan = RoutePlanMapper.INSTANCE.toRouteDatePlan(planRouteRequestDTO);
        planRouteRepository.save(routeDatePlan);
        return "redirect:/routemanager/plannedRoutes?date=" + planRouteRequestDTO.getDate();
    }

    @GetMapping("/routemanager/availableOptions")
    @ResponseBody
    public Map<String, List<?>> getAvailableOptions(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<RouteInfoDTO> routes = routeInfoRepository.findNotFullyPlannedOnDate(date).stream()
                .map(RouteInfoMapper.INSTANCE::toRouteInfoDTO).
                collect(Collectors.toList());
        List<BusDTO> buses = busRepository.findFreeOnDate(date).stream()
                .map(BusMapper.INSTANCE::toBusDTO)
                .collect(Collectors.toList());

        return Map.of("routes", routes, "buses", buses);
    }

}
