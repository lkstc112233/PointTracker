package com.photoncat.pointtracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNamesGenerator {
    private List<String> names;
    private int i = 0;
    public RandomNamesGenerator(List<String> names) {
        this.names = new ArrayList<>(names);
        Collections.shuffle(this.names);
    }

    public String generate() {
        if (i < names.size()) {
            return names.get(i++);
        }
        return "Player " + i;
    }
}
