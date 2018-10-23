package com.example.android.quakereport;

public class Earthquake {

    private String mEarthquakeMagnitude;

    private String mEarthquakeLocation;

    private String mEarthquakeDate;

    public Earthquake (String earthquakeMagnitude, String earthquakeLocation, String earthquakeDate) {

        mEarthquakeMagnitude = earthquakeMagnitude;

        mEarthquakeLocation = earthquakeLocation;

        mEarthquakeDate = earthquakeDate;
    }

    public String getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getEarthquakeLocation() { return mEarthquakeLocation; }

    public String getEarthquakeDate() {
        return mEarthquakeDate;
    }
}
