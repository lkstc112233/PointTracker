package com.photoncat.pointtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    public final static String CONTRACT_PLAYER_COUNT = "player_count";
    public final static String CONTRACT_INITIAL_POINTS = "initial_points";

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int player = intent.getIntExtra(CONTRACT_PLAYER_COUNT, 5);
        int initial = intent.getIntExtra(CONTRACT_INITIAL_POINTS, 1000);

        game = new Game(player, initial);

        setContentView(R.layout.activity_game);
    }
}
