package com.photoncat.pointtracker;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<Player> players;
    public List<Player> allPlayers;

    public int pot = 0;
    public int bet = 0;
    public boolean blindSet = false;

    public Game(int players, int initial) {
        this.players = new ArrayList<>();
        this.allPlayers = new ArrayList<>();
        for (int i = 0; i < players; ++i) {
            this.players.add(new Player("Player " + i, initial));
            this.allPlayers.add(this.players.get(i));
        }
    }

    public void checkOrCall(int id) {
        Player player = players.get(id);
        if (blindSet) {
            player.currentPoint -= (bet - player.roundBet);
            pot += bet - player.roundBet;
            player.roundBet = bet;
        } else {
            blindSet = true;

        }
    }

    public Player fold(int id) {
        return players.remove(id);
    }

    public void raise(int id, int amount) {

    }

    public void roundEnd() {
        blindSet = false;
        players.clear();
        players.addAll(allPlayers);
    }
}
