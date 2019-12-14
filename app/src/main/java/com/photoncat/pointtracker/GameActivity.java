package com.photoncat.pointtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private final static String TAG = GameActivity.class.getSimpleName();
    public final static String CONTRACT_PLAYER_COUNT = "player_count";
    public final static String CONTRACT_INITIAL_POINTS = "initial_points";

    private Game game;
    private PlayerListAdapter adapter;

    private TextView pot;
    private TextView bet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int player = intent.getIntExtra(CONTRACT_PLAYER_COUNT, 5);
        int initial = intent.getIntExtra(CONTRACT_INITIAL_POINTS, 1000);

        game = new Game(player, initial);

        setContentView(R.layout.activity_game);

        pot = findViewById(R.id.pot_size);
        bet = findViewById(R.id.bet_size);

        adapter = new PlayerListAdapter(this, R.layout.player_info, game.players);
        ListView PaysListView = findViewById(R.id.players_list);
        PaysListView.setAdapter(adapter);

        updateView();
    }

    public void roundEndOnClickHandler(View v) {
        game.roundEnd();
        adapter.clear();
        adapter.addAll(game.allPlayers);
        updateView();
    }

    public void checkOrCallOnClickHandler(View v) {
        int playerPosition = (Integer)v.getTag();
        game.checkOrCall(playerPosition);
        updateView();
    }

    public void foldOnClickHandler(View v) {
        int playerPosition = (Integer)v.getTag();
        game.fold(playerPosition);
        updateView();
    }

    public void raiseOnClickHandler(View v) {
        final int playerPosition = (Integer) v.getTag();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.raise));

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        builder.setPositiveButton(getResources().getString(R.string.confirm), (dialog, which) -> {
            try {
                int raiseBy = Integer.valueOf(input.getText().toString());
                if (raiseBy > 0) {
                    game.raise(playerPosition, raiseBy);
                }
            } catch(NumberFormatException e) {
                Log.d(TAG, "NumberFormatException", e);
            }
            updateView();
        });
        builder.setNegativeButton(getResources().getText(R.string.cancel), (dialog, which) -> dialog.cancel());

        builder.show();
    }

    private void updateView() {
        adapter.notifyDataSetChanged();
        pot.setText(Integer.toString(game.pot));
        bet.setText(Integer.toString(game.bet));
    }
}
