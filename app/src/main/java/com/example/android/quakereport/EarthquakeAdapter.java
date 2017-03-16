package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.android.quakereport.R.id.date;
import static com.example.android.quakereport.R.id.location;
import static com.example.android.quakereport.R.id.magnitude;
import static com.example.android.quakereport.R.id.offset;



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

        // Finds the view to inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_item, parent, false);
        }

        // Finds each individual earthquake item in the ArrayList
        Earthquake earthquake = getItem(position);

        // Find each view and cast them appropriately to be used on inflation
        TextView magnitudeView = (TextView) convertView.findViewById(magnitude);
        TextView proximityView = (TextView) convertView.findViewById(offset);
        TextView locationView = (TextView) convertView.findViewById(location);
        TextView dateView = (TextView) convertView.findViewById(date);
        TextView timeView = (TextView) convertView.findViewById(R.id.time);
        GradientDrawable magCircle = (GradientDrawable) magnitudeView.getBackground();

        // Calls getMagnitudeColor on each earthquake, finds the magnitude and sets the appropriate color
        int magnitudeColor = getMagnitudeColor(earthquake.getMagnitude());
        magCircle.setColor(magnitudeColor);

        // Calls formatMagnitude to format the magnitude as a single decimal number
        String formattedMagnitude = formatMagnitude(earthquake.getMagnitude());
        magnitudeView.setText(formattedMagnitude);

        // Searches the earthquake object string to help format the location information
        if (earthquake.getLocation().contains("of")) {
            String[] locationParts = earthquake.getLocation().split("(?<=of)");
            proximityView.setText(locationParts[0]);
            locationView.setText(locationParts[1]);
        } else {
            // if "of" is not found in the string, Sets this string for the offset text
            proximityView.setText(R.string.no_proximity);
            locationView.setText(earthquake.getLocation());
        }

        // Sets the text for date and time with the data returned from each earthquake object
        dateView.setText(earthquake.getDate());
        timeView.setText(earthquake.getTime());

        return convertView;
    }

    // Formats the magnitude as a single digit decimal number
    private String formatMagnitude(double magnitude) {
        DecimalFormat formattedMagnitude = new DecimalFormat("0.0");
        return formattedMagnitude.format(magnitude);

    }

    // Using a switch statement to check the magnitude and determine the color to be set on the circle
    private int getMagnitudeColor(double magnitude) {
        // Instantiate ColorResourceID variable
        int magnitudeColorResourceId;
        // Takes magnitude and rounds the number down to nearest whole number
        int magnitudeFloor = (int) Math.floor(magnitude);
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
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
