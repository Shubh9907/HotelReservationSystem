package com.bridgelabz;

import java.text.ParseException;

public class HotelReservationSystem {
    public static void main(String[] args) throws ParseException, HotelReservationExceptions {
        System.out.println("Welcome to Hotel Reservation System");
        HotelReservationSystemOperations operations = new HotelReservationSystemOperations();

        operations.addHotels();
        System.out.println(operations.findCheapestHotel("REWARDED", "30/11/2021", "01/12/2021"));
        System.out.println(operations.bestRatedHotel());
    }
}