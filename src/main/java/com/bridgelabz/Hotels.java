package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class HotelTest {

    @Test
    void givenFirstHotelName_WhenAddedToList_ShouldHaveTheDetails() {
        boolean result = false;
        HotelReservationSystemOperations obj = new HotelReservationSystemOperations();
        int listSize = obj.hotelList.size();
        if (listSize > 0) {
            result = true;
        }
        Assertions.assertTrue(result);
    }

    @Test
    void givenCustomerType_WhenCheck_ShouldReturnCheapestHotel() throws ParseException, HotelReservationExceptions {
        HotelReservationSystemOperations obj = new HotelReservationSystemOperations();
        obj.addHotels();
        String result = obj.findCheapestHotel("rewarded", "10/12/2022", "10/12/2023");
        Assertions.assertTrue(result.equalsIgnoreCase("Ridgewood"));
    }
}