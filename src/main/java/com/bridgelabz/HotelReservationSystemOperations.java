package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HotelReservationSystemOperations {
    ArrayList<Hotels> hotelList = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    /*
    Method to add details of hotels
     */
    public void addHotels() {
        hotelList.add(new Hotels("Lakewood", 110, 90, 80, 80, 3));
        hotelList.add(new Hotels("Bridgewood", 160, 60, 110, 50, 4));
        hotelList.add(new Hotels("Ridgewood", 220, 150, 100, 40, 5));
//        .
//        .
//        hotelList.add(new Hotels("Ridgewood",220,150,100,40,5));
//
//        System.out.println("Enter Hotel name");
//        String hotelName = scan.next();
//        hotels.setHotelName(hotelName);
//
//        System.out.println("Enter Hotel Rating");
//        int hotelRating = scan.nextInt();
//        hotels.setHotelRating(hotelRating);
//
//        System.out.println("Enter Weekdays Rates for Regular Customers");
//        int regularWeekdayRates = scan.nextInt();
//        hotels.setRegularWeekdaysRates(regularWeekdayRates);
//
//        System.out.println("Enter Weekdays Rates for Rewarded Customers");
//        int rewardedWeekdayRates = scan.nextInt();
//        hotels.setRewardedWeekdaysRates(rewardedWeekdayRates);
//
//        System.out.println("Enter Weekend Rates for Regular Customers");
//        int regularWeekendRates = scan.nextInt();
//        hotels.setRegularWeekendRates(regularWeekendRates);
//
//        System.out.println("Enter Weekend Rates for Rewarded Customers");
//        int rewardedWeekendRates = scan.nextInt();
//        hotels.setRewardedWeekendRates(rewardedWeekendRates);
    }

    public String findCheapestHotel(String customerType, String checkInDate, String checkOutDate) throws ParseException , HotelReservationExceptions {
        final String DATE_PATTERN = "^[0-9]{2}[/][0-9]{2}[/][0-9]{4}$";
        Date inDate = null;
        Date outDate = null;
        int bestRates = 0;
        Hotels cheapest = hotelList.get(0);

//        System.out.println("Enter 1 for Regular Customers\nEnter 2 for Rewarded Customers");
//        System.out.println("Enter Check in date (e.g. dd/mm/yy)");
//        System.out.println("Enter Check Out date (e.g. dd/mm/yy)");

        if (Pattern.matches(DATE_PATTERN, checkInDate) && Pattern.matches(DATE_PATTERN, checkOutDate)) {
//            System.out.println("Valid");
            inDate = new SimpleDateFormat("dd/MM/yy").parse(checkInDate);
            outDate = new SimpleDateFormat("dd/MM/yy").parse(checkOutDate);
//            System.out.println(inDate);
//            System.out.println(outDate);
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