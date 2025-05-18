package com.example.distanceservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class GeocodingResponse {
    private List<Result> results;

    public static class Result {
        @JsonProperty("geometry")
        private Geometry geometry;

        public static class Geometry {
            private double lat;
            @JsonProperty("lng") // Важно: в API используется "lng", а не "lon"
            private double longitude;

            // Геттеры
            public double getLat() { return lat; }
            public double getLng() { return longitude; }
        }

        // Геттер
        public Geometry getGeometry() { return geometry; }
    }

    // Геттер
    public List<Result> getResults() { return results; }
}