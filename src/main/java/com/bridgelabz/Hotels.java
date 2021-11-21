package com.bridgelabz;

/*
This class contains constructor, getters and setters
 */
public class Hotels {
    private String hotelName;
    private int regularWeekdaysRates, regularWeekendRates;
    private int rewardedWeekdaysRates, rewardedWeekendRates;
    private int hotelRating;
    private int totalCost=0;

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

    public void setTotalCost(int cost) {
        this.totalCost=cost;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public String toString () {
        return "Hotel Name- " +getHotelName()+
                "\nHotel Rating- " +getHotelRating();
    }
}
