package com.example.android.viewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.sairat), getString(R.string.movie_description), R.drawable.sairat));
        tours.add(new Tour(getString(R.string.fandry),getString(R.string.movie_description), R.drawable.fandry));
        tours.add(new Tour(getString(R.string.pavsacha_nibandh),getString(R.string.movie_description), R.drawable.pavus));

        TourAdapter tourAdapter = new TourAdapter(this, tours);
        ListView listView = (ListView) findViewById(R.id.movielist);
        listView.setAdapter(tourAdapter);
    }
}
