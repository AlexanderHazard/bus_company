package com.example.carrent.controller;

import com.example.carrent.dao.BusRepository;
import com.example.carrent.dao.BusTechCheckRepository;
import com.example.carrent.dao.BusTechRepairRepository;
import com.example.carrent.dao.models.BusTechCheck;
import com.example.carrent.dao.models.BusTechRepair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller(value = "/tech")
public class TechManagementController {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusTechCheckRepository busTechCheckRepository;
    
    @Autowired
    private BusTechRepairRepository busTechRepairRepository;

    @GetMapping("/tech/techChecks")
    public String getAllChecks(
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(value = "active", defaultValue = "false") boolean active,
            Model model
    ) {

        LocalDate searchDate = date == null ? LocalDate.now() : date;
        List<BusTechCheck> checks = active ? busTechCheckRepository.findAllNotClosedOnDate(searchDate) : busTechCheckRepository.findAllOnDate(searchDate);
        model.addAttribute("techChecks", checks);
        return "plannedTechChecks";
    }

    @GetMapping("/tech/techRepairs")
    public String getAllRepairs(
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(value = "active", defaultValue = "false") boolean active,
            Model model
    ) {
        LocalDate searchDate = date == null ? LocalDate.now() : date;
        List<BusTechRepair> checks = active ? busTechRepairRepository.findAllGoingOnDate(searchDate) : busTechRepairRepository.findAllOnDate(searchDate);
        model.addAttribute("techRepairs", checks);
        return "plannedTechRepairs";
                
    }

    @GetMapping("/tech/planTechCheck")
    public String planTechCheck(Model model) {
        model.addAttribute("buses", busRepository.findAll());
        model.addAttribute("techCheck", new BusTechCheck());
        return "planTechCheck";
    }

    @PostMapping("/tech/planTechCheck")
    public String planTechCheck(@ModelAttribute BusTechCheck busTechCheck) {
        busTechCheckRepository.save(busTechCheck);
        return "redirect:/tech/techChecks?date=" + busTechCheck.getDate() + "&active=true";
    }

    @GetMapping("/tech/closeTechCheck")
    public String closeTechCheck(@RequestParam("techCheckId") Integer techCheckId, Model model) {
        model.addAttribute("techCheck", busTechCheckRepository.findById(techCheckId));
        return "closeTechCheck";
    }

    @PostMapping("/tech/closeTechCheck")
    public String closeTechCheck(@ModelAttribute BusTechCheck busTechCheck) {
        busTechCheckRepository.updateSummary(busTechCheck.getId(), busTechCheck.getSummary());
        return "redirect:/tech/techChecks?date=" + LocalDate.now() + "&active=true";
    }

    @GetMapping("/tech/planTechRepair")
    public String planTechRepair(Model model) {
        model.addAttribute("buses", busRepository.findAll());
        model.addAttribute("techRepair", new BusTechRepair());
        return "planTechRepair";
    }

    @PostMapping("/tech/planTechRepair")
    public String planTechRepair(@ModelAttribute BusTechRepair busTechRepair) {
        busTechRepairRepository.save(busTechRepair);
        return "redirect:/tech/techRepairs?date=" + busTechRepair.getStartDate() + "&active=true";
    }

    @GetMapping("/tech/closeTechRepair")
    public String closeTechRepair(@RequestParam("techRepairId") Integer techRepairId, Model model) {
        model.addAttribute("techRepair", busTechRepairRepository.findById(techRepairId));
        return "closeTechCheck";
    }

    @PostMapping("/tech/closeTechRepair")
    public String closeTechRepair(@ModelAttribute BusTechRepair busTechRepair) {
        busTechCheckRepository.updateSummary(busTechRepair.getId(), busTechRepair.getSummary());
        return "redirect:/tech/techRepairs?date=" + LocalDate.now() + "&active=true";
    }
    
}
