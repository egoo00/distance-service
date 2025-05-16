package com.example.distanceservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Service
public class DistanceService {
    private final Map<String, double[]> cityCoordinates = Map.of(
        "Minsk", new double[]{53.9, 27.5667},
        "Moscow", new double[]{55.7558, 37.6178},
        "Warsaw", new double[]{52.2297, 21.0122}
    );
    public Map<String, Object> calculateDistance(String city1, String city2) {

        Map<String, Object> response = new HashMap<>();
        if (!cityCoordinates.containsKey(city1) || !cityCoordinates.containsKey(city2)) {
            response.put("error", "City not found");
            return response;
        }

        double distance = 666; // Пример хардкода
        response.put("city1", city1);
        response.put("city2", city2);
        response.put("distance", distance);
        response.put("unit", "km");
        return response;
    }
}