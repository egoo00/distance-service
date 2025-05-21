package com.example.distanceservice.service;

import com.example.distanceservice.dto.GeocodingResponse;
import com.example.distanceservice.dto.Geometry;
import com.example.distanceservice.exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingService {
    private final RestTemplate restTemplate;

    @Value("${geocoding.api.url}")
    private String apiUrl;

    @Value("${geocoding.api.key}")
    private String apiKey;

    public GeocodingService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public double[] getCoordinates(String cityName) {
        String url = String.format("%s?q=%s&key=%s", apiUrl, cityName, apiKey);
        ResponseEntity<GeocodingResponse> response = restTemplate.getForEntity(url, GeocodingResponse.class);

        if (response.getBody() == null ||
                response.getBody().getResults() == null ||
                response.getBody().getResults().isEmpty()) {
            throw new CityNotFoundException("City not found: " + cityName);
        }

        Geometry geometry = response.getBody().getResults().get(0).getGeometry();
        return new double[]{geometry.getLat(), geometry.getLng()};
    }
}