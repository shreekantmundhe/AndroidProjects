package com.example.android.sairat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i = getIntent();
        Music music = (Music)i.getSerializableExtra("SongDetails");

        TextView songNameTextView = (TextView) findViewById(R.id.detailsSongName);
        songNameTextView.setText(music.getSongName());

        TextView artistNameTextView = (TextView) findViewById(R.id.detailsSongArtist);
        artistNameTextView.setText(music.getArtistName());

        ImageView iconView = (ImageView) findViewById(R.id.detailsImage);
        iconView.setImageResource(music.getSongImage());
    }
}
