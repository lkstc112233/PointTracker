package com.photoncat.pointtracker;

public class Game {
    public Player[] players;

    public Game(int players, int initial) {
        this.players = new Player[players];
        for (int i = 0; i < players; ++i) {
            this.players[i] = new Player(initial);
        }
    }
}
