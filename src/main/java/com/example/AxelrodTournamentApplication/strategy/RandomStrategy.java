package com.example.AxelrodTournamentApplication.strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random losowy = new Random();

    public int decyduj(int ostatniaDecyzjaPrzeciwnika) {
        return losowy.nextBoolean() ? 1 : -1;
    }
}
