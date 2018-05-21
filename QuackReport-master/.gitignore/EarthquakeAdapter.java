package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;


/**
 * Created by prash on 03-02-2018.
 */

public class EarthquakeAdapter extends ArrayAdapter {

//definfing locction seperator
    public static final String LOCATION_SEPARATOR="of";






    //constructor for earthquakeadapter , which is the data source of the adapter

    public EarthquakeAdapter(Context context, ArrayList<Collection> earthquakes) {
        super(context, 0, earthquakes);
    }


    //giving position to the Collection class for list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        //check if there is any existing list item view then we reuse it
        // other wise convert it into null and inflate  new list item
        View listView = convertView;
        if (listView ==null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.teen_textview,parent,false);
        }


        //find the position of the collection for earthquakes
        Collection  earthquake = (Collection) getItem(position);




        //find the id of the textview which holds the affects
        TextView affecttextView = (TextView) listView.findViewById(R.id.affect);

        String formattedView = formatMagnitude(earthquake.getmAffect());
        //set the textview for display it
        affecttextView.setText(formattedView);






        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) affecttextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquake.getmDate());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);








        String originalLocation = earthquake.getmLocation();

        String primaryLocation;
        String offsetLocation;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            offsetLocation = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            offsetLocation = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }





        //find the id of the textview which holds the location
        TextView primarylocationView = (TextView) listView.findViewById(R.id.primary_location);

        //set the textview for display it
        primarylocationView.setText(primaryLocation);



        //find the id of the textview which holds the location
        TextView locationView2 = (TextView) listView.findViewById(R.id.offset_location);

        //set the textview for display it
        locationView2.setText(offsetLocation);







        //Create date object

        Date dateobject = new Date(earthquake.getmDate());
        //find the id of the textview for which holds th date
        TextView dateView = (TextView) listView.findViewById(R.id.date);

        String FormattedDate= formatDate(dateobject);
        dateView.setText(FormattedDate);



        ///////////////////////////////////////////////////////////////////////////////////////////

        //find the id of the textview for which we show time
        TextView timeview = (TextView) listView.findViewById(R.id.time);

        //set string format
        String FormattedTime = formatTime(dateobject);
        timeview.setText(FormattedTime);

        //return that listview
        return listView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
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
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }


}
