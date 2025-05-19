package com.example.distanceservice.dto;

public class DistanceResponse {
    private final String from;
    private final String to;
    private final double distance;
    private final String unit;

    public DistanceResponse(String from, String to, double distance, String unit) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.unit = unit;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
    }

    public String getUnit() {
        return unit;
    }
}