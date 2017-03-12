package com.example.android.quakereport;

/**
 * Earthquake object stores earthquake information
 */

public class Earthquake {

    private String mMagnitude;
    private String mLocation;
    private String mDate;

    public Earthquake(String magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public String getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    @Override
    public String toString() {
        return "Magnitude: " + mMagnitude + "\n" +
                "Location: " + mLocation + "\n" +
                "Date: " + mDate;
    }
}
