package com.socialmedia.facebook.model;
public class Address {
    private int userId;
    private String userCurrentCity;
    private String userCurrentCityMovedInDate;
    private String userCurrentCityMovedOutDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserCurrentCity() {
        return userCurrentCity;
    }

    public void setUserCurrentCity(String userCurrentCity) {
        this.userCurrentCity = userCurrentCity;
    }

    public String getUserCurrentCityMovedInDate() {
        return userCurrentCityMovedInDate;
    }

    public void setUserCurrentCityMovedInDate(String userCurrentCityMovedInDate) {
        this.userCurrentCityMovedInDate = userCurrentCityMovedInDate;
    }

    public String getUserCurrentCityMovedOutDate() {
        return userCurrentCityMovedOutDate;
    }

    public void setUserCurrentCityMovedOutDate(String userCurrentCityMovedOutDate) {
        this.userCurrentCityMovedOutDate = userCurrentCityMovedOutDate;
    }
}
