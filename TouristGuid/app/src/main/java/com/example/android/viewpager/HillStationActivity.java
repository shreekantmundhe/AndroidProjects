package com.example.android.viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HillStationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.khandala), R.drawable.khandala));
        tours.add(new Tour(getString(R.string.lonavla), R.drawable.lonavla));

        TourAdapter tourAdapter = new TourAdapter(this, tours);
        ListView listView = (ListView) findViewById(R.id.movielist);
        listView.setAdapter(tourAdapter);
    }
}
