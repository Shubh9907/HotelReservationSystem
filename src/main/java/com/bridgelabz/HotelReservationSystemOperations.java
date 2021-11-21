package com.bridgelabz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelReservationSystemOperations {
    ArrayList<Hotels> hotelList = new ArrayList<>();
    List<Hotels> cheapSortedList;


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
    public String findCheapestHotel(String customerType, String checkInDate, String checkOutDate) throws ParseException, HotelReservationExceptions {
        final String DATE_PATTERN = "^[0-9]{2}[/][0-9]{2}[/][0-9]{4}$";
        Date inDate = null;
        Date outDate = null;

        if (Pattern.matches(DATE_PATTERN, checkInDate) && Pattern.matches(DATE_PATTERN, checkOutDate)) {
            inDate = new SimpleDateFormat("dd/MM/yy").parse(checkInDate);
            outDate = new SimpleDateFormat("dd/MM/yy").parse(checkOutDate);
        } else System.out.println("Invalid");

        if (customerType.equalsIgnoreCase("REGULAR")) {
            for (Hotels hotels : hotelList) {
                Date date = inDate;
                while (date.getDate() < outDate.getDate()) {
                    if (date.getDay() == 6 || date.getDay() == 0) {
                        hotels.setTotalCost(hotels.getTotalCost() + hotels.getRegularWeekendRates());
                    } else hotels.setTotalCost(hotels.getTotalCost() + hotels.getRegularWeekdaysRates());

                    long ONE_DAY_MILLI_SECOND = 24 * 60 * 60 * 1000;
                    long nextDayMilliSec = date.getTime()+ONE_DAY_MILLI_SECOND;
                    date = new Date(nextDayMilliSec);
                }
            }
        } else if (customerType.equalsIgnoreCase("REWARDED")) {
            for (Hotels hotels : hotelList) {
                Date date = inDate;
                while (date.getDate() < outDate.getDate()) {
                    if (date.getDay() == 6 || date.getDay() == 0) {
                        hotels.setTotalCost(hotels.getTotalCost() + hotels.getRewardedWeekendRates());
                    } else hotels.setTotalCost(hotels.getTotalCost() + hotels.getRewardedWeekdaysRates());

                    long ONE_DAY_MILLI_SECOND = 24 * 60 * 60 * 1000;
                    long nextDayMilliSec = date.getTime()+ONE_DAY_MILLI_SECOND;
                    date = new Date(nextDayMilliSec);
                }
            }
        } else {
            System.out.println("Please Enter a valid Customer Type, Enter Again");
        }
        cheapSortedList = hotelList.stream().sorted(Comparator.comparing(hotel -> hotel.getTotalCost())).collect(Collectors.toList());
        Hotels Cheapest = cheapSortedList.get(0);
        System.out.println(Cheapest.getTotalCost());
        return Cheapest.getHotelName();
    }

    public String bestRatedHotel() {
        int finalRate = cheapSortedList.get(0).getTotalCost();
        List<Hotels> newSortedList = cheapSortedList.stream().filter(hotel -> hotel.getTotalCost()==finalRate).collect(Collectors.toList());
        List<Hotels> sortedRateOrder = newSortedList.stream().sorted(Comparator.comparing(hotel -> hotel.getHotelRating())).collect(Collectors.toList());
        Hotels bestRatedHotel = sortedRateOrder.get(sortedRateOrder.size()-1);
        System.out.println("Total Cost " +bestRatedHotel.getTotalCost()+ " Rate:- " +bestRatedHotel.getHotelRating());
        return bestRatedHotel.getHotelName();
    }
}