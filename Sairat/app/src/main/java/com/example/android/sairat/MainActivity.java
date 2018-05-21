package com.example.android.sairat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView songsTextview = (TextView) findViewById(R.id.songs);
        songsTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songs = new Intent(MainActivity.this, SongActivity.class);
                startActivity(songs);
            }
        });

        TextView playlistTextView = (TextView) findViewById(R.id.playlist);
        playlistTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlis = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(playlis);
            }
        });

        TextView artistTextView = (TextView) findViewById(R.id.artist);
        artistTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent artist = new Intent(MainActivity.this, ArtistActivity.class);
                startActivity(artist);
            }
        });

        TextView albumTextView = (TextView) findViewById(R.id.albums);
        albumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent album = new Intent(MainActivity.this, AlbumActivity.class);
                startActivity(album);
            }
        });

    }
}
