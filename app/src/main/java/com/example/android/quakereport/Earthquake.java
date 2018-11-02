package com.example.android.quakereport;

public class Earthquake {

    private double mEarthquakeMagnitude;

    private String mEarthquakeLocation;

    private long mEarthquakeDate;

    private String mEarthquakeUrl;

    public Earthquake (double earthquakeMagnitude, String earthquakeLocation, long earthquakeDate, String earthquakeUrl) {

        mEarthquakeMagnitude = earthquakeMagnitude;

        mEarthquakeLocation = earthquakeLocation;

        mEarthquakeDate = earthquakeDate;

        mEarthquakeUrl = earthquakeUrl;
    }

    public double getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getEarthquakeLocation() { return mEarthquakeLocation; }

    public long getEarthquakeDate() {
        return mEarthquakeDate;
    }

    public String getEarthquakeUrl() { return mEarthquakeUrl; }
}
