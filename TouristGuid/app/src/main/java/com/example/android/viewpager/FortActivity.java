package com.example.android.viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class FortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        final ArrayList forts = new ArrayList();

        forts.add(getString(R.string.tikona_description));
        forts.add(getString(R.string.purandar_description));
        forts.add(getString(R.string.torna_description));
        forts. add(getString(R.string.lohagad_description));
        forts.add(getString(R.string.lohagad_description));
        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.tikona), R.drawable.tikona));
        tours.add(new Tour(getString(R.string.purandar), R.drawable.purandar));
        tours.add(new Tour(getString(R.string.torna), R.drawable.torna));
        tours.add(new Tour(getString(R.string.lohagad), R.drawable.lohagad));
        tours.add(new Tour(getString(R.string.sinhagad), R.drawable.sinhagad));

        TourAdapter tourAdapter = new TourAdapter(this, tours);
        ListView listView = (ListView) findViewById(R.id.movielist);
        listView.setAdapter(tourAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String fort = (String) forts.get(position);
                Intent fortDetails = new Intent(FortActivity.this, FortDetailsActivity.class);
                fortDetails.putExtra(getString(R.string.fort_details), fort);
                startActivity(fortDetails);
            }
        });
    }
}
