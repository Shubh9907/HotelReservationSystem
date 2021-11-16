package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddHotelTest {

    @Test
    void addingHotelInList_ShouldHaveTheDetails() {
        int listSize=1;
        HotelReservationSystemOperations obj = new HotelReservationSystemOperations();
        int result = obj.list.size();
        Assertions.assertEquals(listSize,result);
    }
}