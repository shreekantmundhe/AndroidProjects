package com.example.android.sairat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        final ArrayList<Music> music = new ArrayList<Music>();

        music.add(new Music("Lucky Ali", R.drawable.lucky));
        music.add(new Music("Akheel Sachdeva", R.drawable.akheel));
        music.add(new Music("Nino Simon", R.drawable.nino));

        MusicAdapter flavorAdapter = new MusicAdapter(this, music);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(flavorAdapter);
    }
}