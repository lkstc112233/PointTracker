package com.photoncat.pointtracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    public final static String CONTRACT_PLAYER_COUNT = "player_count";
    public final static String CONTRACT_INITIAL_POINTS = "initial_points";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
