package com.example.android.viewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NatakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.natsamrat)));
        tours.add(new Tour(getString(R.string.chor_polis)));
        tours.add(new Tour(getString(R.string.sahi_re_sahi)));

        TourAdapter tourAdapter = new TourAdapter(this, tours);
        ListView listView = (ListView) findViewById(R.id.movielist);
        listView.setAdapter(tourAdapter);
    }
}
