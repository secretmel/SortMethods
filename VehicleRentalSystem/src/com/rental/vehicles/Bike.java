package com.rental.vehicles;

public class Bike extends Vehicle {

    private final boolean hasCarrier;  

    public Bike(String vehicleID, String make, String model) {
        super(vehicleID, make, model);
        this.hasCarrier = false;
    }

    public Bike(String vehicleID, String make, String model, boolean hasCarrier) {
        super(vehicleID, make, model);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public String getVehicleType() {
        return "Bike";  
    }

    public void displayInfo() {
        System.out.println("Vehicle Type: " + getVehicleType() + ", Make: " + getMake() + ", Model: " + getModel() + ", Carrier: " + (hasCarrier ? "Yes" : "No"));
    }

    protected void displayMaintenanceStatus() {
        System.out.println("Bike maintenance status: " + (hasCarrier ? "With Carrier" : "Without Carrier"));
    }

    @SuppressWarnings("unused")
    private void performBikeSpecificMaintenance() {
        System.out.println("Performing specific bike maintenance...");
    }

    @Override
    public String getVehicleID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void scheduleMaintenance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isUnderMaintenance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
