package com.yakubozten.api;

public class HotelBookRequest {
    private String userId;
    private String hotelId;

    @Override
    public String toString() {
        return "HotelBookRequest{" +
                "userId='" + userId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                '}';
    }

    public HotelBookRequest() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
