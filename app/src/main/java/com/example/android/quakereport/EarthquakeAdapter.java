package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    // This private method takes in a double and returns an integer
    private int getMagnitudeColor (double magnitude){
        // magnitudeColorResourceId is the variable storing the color resource ID integer,
        // that the method gets from color resource IDs
        int magnitudeColorResourceId;
        // We convert the input double to an integer,
        // because the switch statement cannot take in doubles
        int magnitudeFloor = (int) Math.floor(magnitude);
        // This statement determines the value of magnitudeColorResourceId
        // depending on the value of the method input
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        // We convert the color resource ID (which is just a reference to a resource)
        // to an actual integer color value and return it
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
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

        // Create formatter and format current earthquake magnitude
        DecimalFormat magFormatter = new DecimalFormat("0.0");
        String formattedMag = magFormatter.format(currentEarthquake.getEarthquakeMagnitude());

        // Pass in the formattedMag String to its TextView
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.quake_magnitude);
        magnitudeTextView.setText(formattedMag);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getEarthquakeMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

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
