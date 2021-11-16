package com.bridgelabz;

import java.text.ParseException;

public class HotelReservationSystem {
    public static void main(String[] args) throws ParseException, HotelReservationExceptions {
        System.out.println("Welcome to Hotel Reservation System");
        HotelReservationSystemOperations operations = new HotelReservationSystemOperations();

        operations.addHotels();
        operations.findCheapestHotel();
    }
}