package com.example.android.quakereport;

public class Earthquake {

    private String mEarthquakeMagnitude;

    private String mEarthquakeLocation;

    private long mEarthquakeDate;

    public Earthquake (String earthquakeMagnitude, String earthquakeLocation, long earthquakeDate) {

        mEarthquakeMagnitude = earthquakeMagnitude;

        mEarthquakeLocation = earthquakeLocation;

        mEarthquakeDate = earthquakeDate;
    }

    public String getEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getEarthquakeLocation() { return mEarthquakeLocation; }

    public long getEarthquakeDate() {
        return mEarthquakeDate;
    }
}
