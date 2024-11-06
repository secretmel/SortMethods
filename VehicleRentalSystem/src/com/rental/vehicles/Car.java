package com.rental.vehicles;

public class Car extends Vehicle {

    public Car(String vehicleID, String make, String model) {
        super(vehicleID, make, model);  
    }

    @Override
    public String getVehicleType() {
        return "Car";  
    }

    @Override
    public String getVehicleID() {
        return super.getVehicleID(); 
    }

    
    @Override
    public void scheduleMaintenance() {
        System.out.println("Scheduling maintenance for Car with ID: " + getVehicleID());
    }

    
    @Override
    public boolean isUnderMaintenance() {
        return false;  
    }
}
