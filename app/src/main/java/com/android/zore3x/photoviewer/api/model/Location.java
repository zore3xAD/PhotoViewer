package com.android.zore3x.photoviewer.api.model;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("city")
    private String mCity;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("position")
    private Position mPosition;

    public Location() {
    }

    public Location(String city, String country, Position position) {
        mCity = city;
        mCountry = country;
        mPosition = position;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public Position getPosition() {
        return mPosition;
    }

    public void setPosition(Position position) {
        mPosition = position;
    }
}
