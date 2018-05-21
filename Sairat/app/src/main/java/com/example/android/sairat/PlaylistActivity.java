package com.example.android.sairat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        final ArrayList<Music> music = new ArrayList<Music>();

        music.add(new Music("Old Songs"));
        music.add(new Music("Latest Songs"));
        music.add(new Music("Kishor Kumar"));

        MusicAdapter flavorAdapter = new MusicAdapter(this, music);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(flavorAdapter);
    }
}
