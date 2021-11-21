package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

class HotelTest {

    @Test
    void givenFirstHotelName_WhenAddedToList_ShouldHaveTheDetails() {
        boolean result = false;
        HotelReservationSystemOperations obj = new HotelReservationSystemOperations();
        obj.addHotels();
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
        String result = obj.findCheapestHotel("REWARDED", "27/11/2021", "28/11/2021");
        Assertions.assertEquals("Ridgewood",result);
    }
}