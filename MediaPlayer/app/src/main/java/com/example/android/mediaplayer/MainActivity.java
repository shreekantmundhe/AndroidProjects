package com.example.android.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.audio);
        Button play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
    }
}
