package com.photoncat.pointtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = WelcomeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        final EditText playerCount = findViewById(R.id.players_count);
        final EditText initialPoint = findViewById(R.id.initial_points);

        Button startGame = findViewById(R.id.start_game);
        startGame.setOnClickListener(event->{
            Intent intent = new Intent(this, GameActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
            try {
                int players = Integer.valueOf(playerCount.getText().toString());
                if (players > 0) {
                    intent.putExtra(GameActivity.CONTRACT_PLAYER_COUNT, players);
                }
                int initial = Integer.valueOf(initialPoint.getText().toString());
                if (initial > 0) {
                    intent.putExtra(GameActivity.CONTRACT_INITIAL_POINTS, initial);
                }
            } catch(NumberFormatException e) {
                Log.d(TAG, "NumberFormatException", e);
            }
            startActivity(intent);
            finish();
        });
    }
}
