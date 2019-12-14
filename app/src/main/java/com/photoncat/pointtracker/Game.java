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
            bet = 2;
            player.roundBet = 1;
            player.currentPoint -= 1;
            Player bigBlind = players.get((id+1)%players.size());
            bigBlind.roundBet = 2;
            bigBlind.currentPoint -= 2;
            pot += 3;
        }
    }

    public Player fold(int id) {
        return players.remove(id);
    }

    public void raise(int id, int amount) {
        Player player = players.get(id);
        bet += amount;
        player.currentPoint -= (bet - player.roundBet);
        pot += bet - player.roundBet;
        player.roundBet = bet;
    }

    public void roundEnd() {
        int survivalPlayers = players.size();
        if (survivalPlayers > 0) {
            int pointsPerPlayer = pot / survivalPlayers;
            pot = pot % survivalPlayers;
            for (Player player : players) {
                player.currentPoint += pointsPerPlayer;
            }
        }
        bet = 0;
        blindSet = false;
        players.clear();
        players.addAll(allPlayers);
    }
}
