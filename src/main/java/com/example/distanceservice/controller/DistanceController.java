package com.example.distanceservice.controller;

import com.example.distanceservice.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DistanceController {
    @Autowired
    private final DistanceService distanceService;

    DistanceController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/distance")
    public Map<String, Object> calculateDistance(
            @RequestParam String city1,
            @RequestParam String city2){
        return distanceService.calculateDistance(city1, city2);
    }

}