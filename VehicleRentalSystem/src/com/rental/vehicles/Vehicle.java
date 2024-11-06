package com.rental.vehicles;

import com.rental.interfaces.Rentable;

public abstract class Vehicle implements Rentable {
    private final String vehicleID;
    private final String make;
    private final String model;
    private boolean isAvailable;
    @SuppressWarnings("unused")
    private final boolean underMaintenance;

    public static int vehicleCount = 0;

    public Vehicle(String vehicleID, String make, String model) {
        this.vehicleID = vehicleID;
        this.make = make;
        this.model = model;
        this.isAvailable = true;
        this.underMaintenance = false;
        vehicleCount++;
    }

    public abstract String getVehicleType();

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    @Override
    public void rent() {
        if (isAvailable) {
            System.out.println("Renting the " + getVehicleType() + ": " + make + " " + model);
            isAvailable = false;
        } else {
            System.out.println("Sorry, this " + getVehicleType() + " is already rented.");
        }
    }

    @Override
    public void returnVehicle() {
        System.out.println("Returning the " + getVehicleType() + ": " + make + " " + model);
        isAvailable = true;
    }

    public static int getVehicleCount() {
        return vehicleCount;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public String getVehicleID() {
        return vehicleID;  
    }

    protected abstract boolean isUnderMaintenance();

    public abstract void scheduleMaintenance();
}
