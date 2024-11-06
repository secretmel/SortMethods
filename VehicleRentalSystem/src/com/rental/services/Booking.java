package com.rental.services;

import com.rental.customers.Customer;
import com.rental.vehicles.Vehicle;

public class Booking {
    private final Customer customer;
    private final Vehicle vehicle;
    @SuppressWarnings("unused")
    private final String bookingID;

    protected boolean isConfirmed;

    public static class BookingUtils {
        public static void printBookingInfo(Customer customer, Vehicle vehicle) {
            System.out.println("Booking details: " + customer.getName() + " for vehicle: " + vehicle.getVehicleType());
        }
    }

    public Booking(Customer customer, Vehicle vehicle, String bookingID) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.bookingID = bookingID;
        this.isConfirmed = false;
    }

    public void confirmBooking() {
        BookingUtils.printBookingInfo(customer, vehicle);
        vehicle.rent();
    }
}
