package com.company.service;

public final class InsuranceCalculationResult {
    private final String id;
    private final int cost;
    private final String vehicleTypeName;

    public InsuranceCalculationResult(String vehicleTypeName, String id, int cost) {
        this.id = id;
        this.cost = cost;
        this.vehicleTypeName = vehicleTypeName;
    }

    public String getVehicleTypeName(){
        return vehicleTypeName;
    }

    public String getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }
}