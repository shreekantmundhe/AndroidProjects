package com.example.android.viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class PicnicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.forts), R.drawable.fort));
        tours.add(new Tour(getString(R.string.hill_stations), R.drawable.hill));

        TourAdapter tourAdapter = new TourAdapter(this, tours);
        ListView listView = (ListView) findViewById(R.id.movielist);
        listView.setAdapter(tourAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tour fort = (Tour) tours.get(position);
                if(fort.getTourName() == getString(R.string.forts)) {
                    Intent fortDetails = new Intent(PicnicActivity.this, FortActivity.class);
                    startActivity(fortDetails);
                }
                else if(fort.getTourName() == getString(R.string.hill_stations)) {
                    Intent fortDetails = new Intent(PicnicActivity.this, HillStationActivity.class);
                    startActivity(fortDetails);
                }
            }
        });

    }
}
