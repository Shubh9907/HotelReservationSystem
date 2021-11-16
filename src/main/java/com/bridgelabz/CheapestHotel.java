package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

public class CheapestHotel {
    ArrayList<Hotels> hotelList = new ArrayList<>();

    /*
    Method to add details of hotels
     */
    public void addHotels() {
        hotelList.add(new Hotels("Lakewood", 110, 90, 80, 80, 3));
        hotelList.add(new Hotels("Bridgewood", 160, 60, 110, 50, 4));
        hotelList.add(new Hotels("Ridgewood", 220, 150, 100, 40, 5));
    }

    /*
    Method for find cheapest hotel for test case
    return cheapest hotel name
     */
    public String findCheapestHotel(String customerType, String checkInDate, String checkOutDate) throws ParseException, HotelReservationExceptions {
        final String DATE_PATTERN = "^[0-9]{2}[/][0-9]{2}[/][0-9]{4}$";
        Date inDate = null;
        Date outDate = null;
        int bestRates = 0;
        Hotels cheapest = hotelList.get(0);

        if (Pattern.matches(DATE_PATTERN, checkInDate) && Pattern.matches(DATE_PATTERN, checkOutDate)) {
            inDate = new SimpleDateFormat("dd/MM/yy").parse(checkInDate);
            outDate = new SimpleDateFormat("dd/MM/yy").parse(checkOutDate);
        } else System.out.println("Invalid");

        boolean check = true;

        if (customerType.equalsIgnoreCase("REGULAR")) {
            if (inDate.getDay() == 6 || inDate.getDay() == 7) {
                for (Hotels hotels : hotelList) {
                    if (cheapest.getRegularWeekendRates() > hotels.getRegularWeekendRates()) {
                        cheapest = hotels;
                        bestRates = cheapest.getRegularWeekendRates();
                    }
                }
            } else {
                for (Hotels hotels : hotelList) {
                    if (cheapest.getRegularWeekdaysRates() > hotels.getRegularWeekdaysRates()) {
                        cheapest = hotels;
                        bestRates = cheapest.getRegularWeekdaysRates();
                    }
                }
            }
        } else if (customerType.equalsIgnoreCase("Rewarded")) {
            if (inDate.getDay() == 6 || inDate.getDay() == 7) {
                for (Hotels hotels : hotelList) {
                    if (cheapest.getRewardedWeekendRates() > hotels.getRewardedWeekendRates()) {
                        cheapest = hotels;
                        bestRates = cheapest.getRewardedWeekendRates();
                    }
                }
            } else {
                for (Hotels hotels : hotelList) {
                    if (cheapest.getRewardedWeekdaysRates() > hotels.getRewardedWeekdaysRates()) {
                        cheapest = hotels;
                        bestRates = cheapest.getRewardedWeekdaysRates();
                    }
                }
            }
        } else {
            System.out.println("Please Enter a valid Customer Type, Enter Again");
            check = false;
            findCheapestHotel(customerType,checkInDate,checkOutDate);
        }
        if (check == true) {
            System.out.println("The Cheapest hotel is:-\n" + cheapest.toString());
            System.out.println("Best Rates for you is- " + bestRates);
        }
        return cheapest.getHotelName();
    }
}
