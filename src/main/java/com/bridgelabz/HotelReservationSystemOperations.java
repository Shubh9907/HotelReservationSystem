package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystemOperations {
    ArrayList<Hotels> list = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    /*
    Method to add details of hotels
     */
    public void addHotels() {
        Hotels hotels = new Hotels();

        System.out.println("Enter Hotel name");
        String hotelName = scan.nextLine();
        hotels.setHotelName(hotelName);

        System.out.println("Enter Rates for Regular Customer");
        int rates = scan.nextInt();
        hotels.setRegularRates(rates);

        this.list.add(hotels);
    }
}
