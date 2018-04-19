package com.company.model;

public class VehicleInfo {
    private String id;
    private String vehicleTypeName;
    private String vehicleTypeFormula;
    private int age;
    private long numberOfMiles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleInfo(String id, int age, long numberOfMiles, boolean isDiesel) {
        this.id = id;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public VehicleInfo(String id, String vehicleTypeName, int age, long numberOfMiles, boolean isDiesel) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public VehicleInfo(String id, String vehicleTypeName, String vehicleTypeFormula, int age, long numberOfMiles, boolean isDiesel) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.vehicleTypeFormula = vehicleTypeFormula;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public void setVehicleTypeName(String vehicleTypeName) {
        this.vehicleTypeName = vehicleTypeName;
    }

    public String getVehicleTypeFormula() {
        return vehicleTypeFormula;
    }

    public void setVehicleTypeFormula(String vehicleTypeFormula) {
        this.vehicleTypeFormula = vehicleTypeFormula;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNumberOfMiles() {
        return numberOfMiles;
    }

    public void setNumberOfMiles(long numberOfMiles) {
        this.numberOfMiles = numberOfMiles;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public void setDiesel(boolean diesel) {
        isDiesel = diesel;
    }

    private boolean isDiesel;
}
