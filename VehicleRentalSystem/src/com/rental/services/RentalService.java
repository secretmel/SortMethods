package com.rental.services;

import com.rental.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private final List<Vehicle> vehicles;
    public static int totalRentals = 0;
    public RentalService() {
        vehicles = new ArrayList<>();
    }

    protected boolean serviceOpen;

    public static int getTotalRentals() {
        return totalRentals;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void rentVehicle(String vehicleID) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleID().equals(vehicleID)) {
                vehicle.rent();
                totalRentals++; 
                System.out.println("You have rented: " + vehicle.getVehicleType() + " " + vehicle.getModel() + " with ID " + vehicle.getVehicleID());
                return;
            }
        }
        System.out.println("Vehicle with ID " + vehicleID + " not found.");
    }

    public void returnVehicle(String vehicleID) {
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.getVehicleID().equals(vehicleID)) {
            } else {
                vehicle.returnVehicle();
                System.out.println("You have returned: " + vehicle.getVehicleType() + " " + vehicle.getModel() + " with ID " + vehicle.getVehicleID());
                return;
            }
        }
        System.out.println("Vehicle with ID " + vehicleID + " not found.");
    }

    @SuppressWarnings("CollectionsToArray")
    public Vehicle[] getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles.toArray(new Vehicle[0]);
    }

    public void displayAvailableVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : getAvailableVehicles()) {
            System.out.println(vehicle.getVehicleID() + ": " + vehicle.getModel() + " " + vehicle.getModel());
        }
    }
}
