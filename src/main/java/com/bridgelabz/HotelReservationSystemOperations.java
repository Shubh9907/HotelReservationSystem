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
    }

    /*
    Method to find the cheapest hotel in a given date range
     */
    public String findCheapestHotel() throws ParseException , HotelReservationExceptions , NullPointerException {
        final String DATE_PATTERN = "^[0-2][0-9][/][0-1][0-9][/][0-9]{4}$"; // Regex Pattern for validation of dates
        Date inDate = null;
        Date outDate = null;
        boolean check = true;

        Hotels cheapest = hotelList.get(0); // value at index 0 will assign to cheapest
        int bestRates = 0;

        System.out.println("Enter 1 for Regular Customers\nEnter 2 for Rewarded Customers");
        int customerType = scan.nextInt();
        System.out.println("Enter Check in date (e.g. dd/mm/yy)");
        String checkInDate = scan.next();
        System.out.println("Enter Check Out date (e.g. dd/mm/yy)");
        String checkOutDate = scan.next();

        if (Pattern.matches(DATE_PATTERN, checkInDate) && Pattern.matches(DATE_PATTERN, checkOutDate)) {
            inDate = new SimpleDateFormat("dd/MM/yy").parse(checkInDate); // Converts String in a Date
            outDate = new SimpleDateFormat("dd/MM/yy").parse(checkOutDate); // Converts String in a Date
        }

        try {
            if (customerType == 1) {
                boolean flag = false;
                if (inDate.getDay() == 6 || inDate.getDay() == 7) {  // inDate.getDay() will return a day in integer
                    for (Hotels hotels : hotelList) {
                        if (cheapest.getRegularWeekendRates() > hotels.getRegularWeekendRates()) {
                            flag = true;
                            cheapest = hotels;
                            bestRates = cheapest.getRegularWeekendRates();
                        }else {
                            if (flag==false) {
                                bestRates = cheapest.getRegularWeekendRates();
                            }
                        }
                    }
                } else {
                    boolean flag1 = false;
                    for (Hotels hotels : hotelList) {
                        if (cheapest.getRegularWeekdaysRates() > hotels.getRegularWeekdaysRates()) {
                            flag1=true;
                            cheapest = hotels;
                            bestRates = cheapest.getRegularWeekdaysRates();
                        }else {
                            if (flag1==false) {
                                bestRates = cheapest.getRegularWeekdaysRates();
                            }
                        }
                    }
                }
            } else if (customerType == 2) {
                boolean flag2 = false;
                if (inDate.getDay() == 6 || inDate.getDay() == 7) {
                    for (Hotels hotels : hotelList) {
                        if (cheapest.getRewardedWeekendRates() > hotels.getRewardedWeekendRates()) {
                            cheapest = hotels;
                            flag2 = true;
                            bestRates = cheapest.getRewardedWeekendRates();
                        }else {
                            if (flag2==false) bestRates = cheapest.getRewardedWeekendRates();
                        }
                    }
                } else {
                    boolean flag3 =false;
                    for (Hotels hotels : hotelList) {
                        if (cheapest.getRewardedWeekdaysRates() > hotels.getRewardedWeekdaysRates()) {
                            cheapest = hotels;
                            flag3=true;
                            bestRates = cheapest.getRewardedWeekdaysRates();
                        }else {
                            if (flag3==false) bestRates = cheapest.getRewardedWeekdaysRates();
                        }
                    }
                }
                bestRates=cheapest.getRewardedWeekdaysRates();
            } else {
                System.out.println("Please Enter a valid Customer Type, Enter Again");
                check = false;
                findCheapestHotel(); 
            }
            if (check == true) {
                System.out.println("The Cheapest hotel is:-\n" + cheapest.toString());
                System.out.println("Best Rates for you is- " + bestRates);
            }
        }catch (NullPointerException e) {
            System.out.println("Please Enter valid dates");
        }
        return cheapest.getHotelName();
    }
}