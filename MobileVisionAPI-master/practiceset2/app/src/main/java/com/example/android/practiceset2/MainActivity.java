package com.example.android.practiceset2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int teamAScore = 0;
    int teamBScore = 0;
    TextView teamAScoreTextView, teamBScoreTextView, resultTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamAScoreTextView = (TextView) findViewById(R.id.team_a_score);
        teamBScoreTextView = (TextView) findViewById(R.id.team_b_score);
        resultTextView = (TextView) findViewById(R.id.result_text);
    }

    public void teamAFoul(View view) {
        if (teamAScore != 0) {
            teamAScore = teamAScore - 1;
        }
        teamAScoreTextView.setText("" +teamAScore);
    }

    public void teamBFoul(View view) {
        if (teamBScore != 0) {
            teamBScore = teamBScore - 1;
        }
        teamBScoreTextView.setText("" +teamBScore);
    }

    public void teamATwoPoint(View view) {
        teamAScore = teamAScore + 2;
        teamAScoreTextView.setText("" +teamAScore);
    }

    public void teamBTwoPoint(View view) {
        teamBScore = teamBScore + 2;
        teamBScoreTextView.setText("" +teamBScore);
    }
    public void teamBThreePoint(View view) {

        teamBScore = teamBScore + 3;
        teamBScoreTextView.setText("" +teamBScore);
    }

    public void teamAThreePoint(View view) {
        teamAScore = teamAScore + 3;
        //teamAScoreTextView = (TextView) findViewById(R.id.team_a_score);
        teamAScoreTextView.setText("" +teamAScore);
    }

    public void result(View view) {
        Button resultButton = (Button) findViewById(R.id.team_result);
        if (resultButton.getText().toString().trim().equals("Result")){
            resultButton.setText("Reset");
            String result = "Total score of Team A is: " + teamAScore +
                    "\nTotal score of Team B is: " + teamBScore;
            if (teamAScore > teamBScore) {
                resultTextView.setText(result + "\n  Team A is Winner");
            } else if (teamAScore < teamBScore) {
                resultTextView.setText(result + "\n  Team B is Winner");
            } else {
                resultTextView.setText(result + "\nMatch Draw");
            }
        } else if (resultButton.getText().toString().trim().equals("Reset")){
            resultButton.setText("Result");
            teamAScore = 0;
            teamBScore = 0;
            resultTextView.setText("");
            teamAScoreTextView.setText("");
            teamBScoreTextView.setText("");
        }

    }
}
