package com.photoncat.pointtracker;

public class Player {
    public String name;
    public int currentPoint = 0;

    public Player(String name, int initial) {
        this.name = name;
        this.currentPoint = initial;
    }
}
