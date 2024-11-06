package com.rental;

import com.rental.services.RentalService;
import com.rental.vehicles.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();

        Vehicle car = new Car("C123", "Toyota", "Camry");
        Vehicle bike = new Bike("B123", "Yamaha", "YZF-R3");
        Vehicle truck = new Truck("T123", "Ford", "F-150");

        rentalService.addVehicle(car);
        rentalService.addVehicle(bike);
        rentalService.addVehicle(truck);

        try (
                Scanner scanner = new Scanner(System.in)) {
            String userInput;
            OUTER:
            while (true) {
                System.out.println("\nOptions:");
                System.out.println("1. Rent Vehicle");
                System.out.println("2. Return Vehicle");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "1" -> {
                        System.out.print("Enter the vehicle ID to rent: ");
                        String vehicleID = scanner.nextLine();
                        rentalService.rentVehicle(vehicleID);
                    }
                    case "2" -> {
                        System.out.print("Enter the vehicle ID to return: ");
                        String vehicleID = scanner.nextLine();
                        rentalService.returnVehicle(vehicleID);
                    }
                    case "3" -> {
                        System.out.println("Exiting the rental service.");
                        break OUTER; 
                    }
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
        }
    }
}
