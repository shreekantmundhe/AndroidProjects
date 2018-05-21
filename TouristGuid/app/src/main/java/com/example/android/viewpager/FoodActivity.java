package com.example.android.viewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.misal_pav)));
        tours.add(new Tour(getString(R.string.bunmaska)));
        tours.add(new Tour(getString(R.string.bhel)));

        TourAdapter tourAdapter = new TourAdapter(this, tours);
        ListView listView = (ListView) findViewById(R.id.movielist);
        listView.setAdapter(tourAdapter);
    }
}
