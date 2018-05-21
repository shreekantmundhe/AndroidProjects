package com.example.android.viewpager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FortDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fort_details);
        Intent i = getIntent();
        String details = (String)i.getSerializableExtra(getString(R.string.fort_details));

        TextView songNameTextView = (TextView) findViewById(R.id.fort_details);
        songNameTextView.setText(details);

    }
}
