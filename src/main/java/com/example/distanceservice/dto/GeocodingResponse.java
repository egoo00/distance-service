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
            @JsonProperty("lng")
            private double longitude;


            public double getLat() { return lat; }
            public double getLng() { return longitude; }
        }


        public Geometry getGeometry() { return geometry; }
    }


    public List<Result> getResults() { return results; }
}