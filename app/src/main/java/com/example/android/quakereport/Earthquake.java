package com.example.android.quakereport;

/**
 * Created by Othesius on 3/11/17.
 */

public class Earthquake {

    private int mMagnitude;
    private String mLocation;
    private String mDate;

    public Earthquake(int magnitude, String location, String date) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
    }

    public int getMagnitude() {
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
