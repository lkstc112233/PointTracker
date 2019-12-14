package com.photoncat.pointtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        EditText playerCount = findViewById(R.id.players_count);
        EditText initialPoint = findViewById(R.id.initial_points);

        Button startGame = findViewById(R.id.start_game);
        startGame.setOnClickListener(e->{});
    }
}
