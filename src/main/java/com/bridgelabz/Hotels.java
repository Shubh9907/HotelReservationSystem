package com.bridgelabz;

/*
Class having constructors, getters and setters
 */
class Hotels {
    private String hotelName;
    private int regularWeekdaysRates, regularWeekendRates;
    private int rewardedWeekdaysRates, rewardedWeekendRates;
    private int hotelRating;

    public Hotels(String hotelName,int regularWeekdaysRates, int regularWeekendRates, int rewardedWeekdaysRates, int rewardedWeekendRates, int hotelRating) {
        this.hotelName = hotelName;
        this.regularWeekdaysRates = regularWeekdaysRates;
        this.regularWeekendRates = regularWeekendRates;
        this.rewardedWeekdaysRates = rewardedWeekdaysRates;
        this.rewardedWeekendRates = rewardedWeekendRates;
        this.hotelRating = hotelRating;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRegularWeekdaysRates() {
        return regularWeekdaysRates;
    }

    public void setRegularWeekdaysRates(int regularWeekdaysRates) {
        this.regularWeekdaysRates = regularWeekdaysRates;
    }

    public int getRegularWeekendRates() {
        return regularWeekendRates;
    }

    public void setRegularWeekendRates(int regularWeekendRates) {
        this.regularWeekendRates = regularWeekendRates;
    }

    public int getRewardedWeekdaysRates() {
        return rewardedWeekdaysRates;
    }

    public void setRewardedWeekdaysRates(int rewardedWeekdaysRates) {
        this.rewardedWeekdaysRates = rewardedWeekdaysRates;
    }

    public int getRewardedWeekendRates() {
        return rewardedWeekendRates;
    }

    public void setRewardedWeekendRates(int rewardedWeekendRates) {
        this.rewardedWeekendRates = rewardedWeekendRates;
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) {
        this.hotelRating = hotelRating;
    }

    public String toString () {
        return "Hotel Name- " +getHotelName()+
                "\nHotel Rating- " +getHotelRating();
    }
}