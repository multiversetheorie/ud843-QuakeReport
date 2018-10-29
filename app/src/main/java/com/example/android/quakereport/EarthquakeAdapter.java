package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.quake_magnitude);
        magnitudeTextView.setText(currentEarthquake.getEarthquakeMagnitude());

        // Split raw location into primary location and location offset
        String rawLocation = currentEarthquake.getEarthquakeLocation();
        String lookupCharSequence = "of";
        String locationOffset;
        String locationPrimary;
        if (rawLocation.contains(lookupCharSequence)) {
            locationOffset = rawLocation.substring(0,rawLocation.indexOf(lookupCharSequence)+2);
            locationPrimary = rawLocation.substring(rawLocation.indexOf(lookupCharSequence)+3,rawLocation.length());
        }
        else {
            locationPrimary = rawLocation;
            locationOffset = "Near the";
        }

        // Pass in locationOffset String to its TextView
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(R.id.quake_location_offset);
        locationOffsetTextView.setText(locationOffset);
        // Pass in locationPrimary String to its TextView
        TextView locationPrimaryTextView = (TextView) listItemView.findViewById(R.id.quake_location_primary);
        locationPrimaryTextView.setText(locationPrimary);

        // Format date of current earthquake as two different date formats: date and time
        Date earthquakeDateObject = new Date(currentEarthquake.getEarthquakeDate());
        SimpleDateFormat earthquakeDateFormatter = new SimpleDateFormat("yyyy.MM.dd");
        SimpleDateFormat earthquakeTimeFormatter = new SimpleDateFormat("HH:mm");
        String dateToDisplay = earthquakeDateFormatter.format(earthquakeDateObject);
        String timeToDisplay = earthquakeTimeFormatter.format(earthquakeDateObject);

        TextView dateDateTextView = (TextView) listItemView.findViewById(R.id.quake_date);
        dateDateTextView.setText(dateToDisplay);

        TextView dateTimeTextView = (TextView) listItemView.findViewById(R.id.quake_time);
        dateTimeTextView.setText(timeToDisplay);

        return listItemView;
    }


}
