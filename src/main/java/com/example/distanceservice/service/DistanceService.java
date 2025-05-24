package com.example.distanceservice.service;

import com.example.distanceservice.dto.DistanceResponse;
import com.example.distanceservice.entity.City;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {
    private final GeocodingService geocodingService;

    public DistanceService(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    public DistanceResponse calculateDistance(String city1, String city2) {
        City c1 = geocodingService.getCity(city1);
        City c2 = geocodingService.getCity(city2);

        double distance = calculateHaversine(
                c1.getLatitude(), c1.getLongitude(),
                c2.getLatitude(), c2.getLongitude()
        );

        return new DistanceResponse(city1, city2, distance, "km");
    }

    private double calculateHaversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Радиус Земли в км
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }
}