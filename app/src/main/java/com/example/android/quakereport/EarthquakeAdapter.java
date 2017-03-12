package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * EarthqakeAdapter extends ArrayAdapter to accommodate more views for the Earthquake information
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    // Finds a view to inflate
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        TextView magnitude = (TextView) convertView.findViewById(R.id.magnitude);
        TextView location = (TextView) convertView.findViewById(R.id.location);
        TextView date = (TextView) convertView.findViewById(R.id.date);

        magnitude.setText(earthquake.getMagnitude());
        location.setText(earthquake.getLocation());
        date.setText(earthquake.getDate());


        return convertView;
    }
}
