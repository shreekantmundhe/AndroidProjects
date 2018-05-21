package com.example.android.viewpager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by shrikantm on 03/05/2018.
 */

public class TourAdapter extends ArrayAdapter<Tour> {

    public TourAdapter(Activity context, ArrayList<Tour> tour) {
        super(context, 0, tour);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tour_list, parent, false);
        }

        Tour music = getItem(position);

        TextView tourNameTextView = (TextView) listItemView.findViewById(R.id.tour_name);
        tourNameTextView.setText(music.getTourName());

        TextView tourDescriptionTextView = (TextView) listItemView.findViewById(R.id.tour_description);
        if(music.hasTourDescription()) {
            tourDescriptionTextView.setText(music.getTourDescription());
        }
        else {
            tourDescriptionTextView.setVisibility(View.GONE);
        }

        ImageView iconView = (ImageView) listItemView.findViewById(R.id.tour_image);
        if(music.hasTourImage()) {
            iconView.setImageResource(music.getTourImage());
        }
        else {
            iconView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}


