package com.bridgelabz;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class HotelTest {

    HotelReservationSystemOperations obj = new HotelReservationSystemOperations();

    @Test
    void givenFirstHotelName_WhenAddedToList_ShouldHaveTheDetails() {
        boolean result = false;
        obj.addHotels();
        int listSize = obj.hotelList.size();
        if (listSize > 0) {
            result = true;
        }
        Assertions.assertTrue(result);
    }

    @Test
    void givenCustomerType_WhenCheck_ShouldReturnCheapestHotel() throws ParseException, HotelReservationExceptions {
        obj.addHotels();
        String result = obj.findCheapestHotel("REWARDED", "27/11/2021", "28/11/2021");
        Assertions.assertEquals("Ridgewood", result);
    }

    @Test
    void givenCustomerType_WhenCheck_ShouldReturnCheapestBestRatedHotel() throws HotelReservationExceptions, ParseException {
        obj.addHotels();
        obj.findCheapestHotel("REWARDED", "27/11/2021", "28/11/2021");
        String result = obj.bestRatedHotel();
        Assertions.assertEquals("Ridgewood", result);
    }
}