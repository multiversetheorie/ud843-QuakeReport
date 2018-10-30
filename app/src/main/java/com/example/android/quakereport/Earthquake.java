package com.example.android.quakereport;

public class Earthquake {

    private double mEarthquakeMagnitude;

    private String mEarthquakeLocation;

    private long mEarthquakeDate;

    public Earthquake (double earthquakeMagnitude, String earthquakeLocation, long earthquakeDate) {

        mEarthquakeMagnitude = earthquakeMagnitude;

        mEarthquakeLocation = earthquakeLocation;

        mEarthquakeDate = earthquakeDate;
    }

    public double getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getEarthquakeLocation() { return mEarthquakeLocation; }

    public long getEarthquakeDate() {
        return mEarthquakeDate;
    }
}
