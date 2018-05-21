package com.example.android.sairat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        final ArrayList<Music> musics = new ArrayList<Music>();

        musics.add(new Music("O sanam", "Lucky Ali", R.drawable.lucky));
        musics.add(new Music("Sun mere humsafar", "Akheel Sachdeva", R.drawable.akheel));
        musics.add(new Music("Hairat he", "Lucky Ali", R.drawable.lucky));
        musics.add(new Music("I feel good", "Nino Simon", R.drawable.nino));
        musics.add(new Music("Teri yade ati he", "Lucky Ali", R.drawable.lucky));
        musics.add(new Music("If you knew", "Lucky Ali", R.drawable.nino));

        MusicAdapter flavorAdapter = new MusicAdapter(this, musics);
        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(flavorAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music music = musics.get(position);
                Intent songDetails = new Intent(SongActivity.this, DetailsActivity.class);
                songDetails.putExtra("SongDetails", (Serializable) music);
                startActivity(songDetails);
            }
        });
    }
}
