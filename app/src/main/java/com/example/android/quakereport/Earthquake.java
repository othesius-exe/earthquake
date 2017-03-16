package com.example.android.quakereport;
/**
 * Earthquake object stores earthquake information
 */

public class Earthquake {

    private double mMagnitude;
    private String mLocation;
    private String mDate;
    private String mTime;
    private String mUrl;

    public Earthquake(double magnitude, String location, String date, String time, String url) {
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;
        mTime = time;
        mUrl = url;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public String getDate() {
        return mDate;
    }

    public String getTime() {
        return mTime;
    }

    public String getUrl() {
        return mUrl;
    }

    @Override
    public String toString() {
        return "Magnitude: " + mMagnitude + "\n" +
                "Location: " + mLocation + "\n" +
                "Date: " + mDate + "\n" +
                "Time: " + mTime + "\n" +
                "URL: " + mUrl;
    }
}
