package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.quake_location);
        locationTextView.setText(currentEarthquake.getEarthquakeLocation());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.quake_date);
        dateTextView.setText(currentEarthquake.getEarthquakeDate());

        return listItemView;
    }


}
