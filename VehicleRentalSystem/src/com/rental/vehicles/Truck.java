package com.rental.vehicles;

public class Truck extends Vehicle {

    public Truck(String vehicleID, String make, String model) {
        super(vehicleID, make, model);  
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }

    
    @Override
    public String getVehicleID() {
        return super.getVehicleID(); 
    }

    
    @Override
    public void scheduleMaintenance() {
        System.out.println("Scheduling maintenance for Truck with ID: " + getVehicleID());
    }

    @Override
    protected boolean isUnderMaintenance() {
        throw new UnsupportedOperationException("Unimplemented method 'isUnderMaintenance'");
    }
}
