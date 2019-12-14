package com.photoncat.pointtracker;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> players;
    public List<Player> allPlayers;

    public Game(int players, int initial) {
        this.players = new ArrayList<>();
        this.allPlayers = new ArrayList<>();
        for (int i = 0; i < players; ++i) {
            this.players.add(new Player(initial));
            this.allPlayers.add(this.players.get(i));
        }
    }

    public void checkOrCall(int id) {
    }

    public Player fold(int id) {
        return players.remove(id);
    }

    public void raise(int id, int amount) {

    }
}
