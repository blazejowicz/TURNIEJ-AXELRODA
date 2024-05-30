package com.example.AxelrodTournamentApplication.strategy;

public class AlwaysUnfair implements Strategy {
    public int decyduj(int ostatniaDecyzjaPrzeciwnika) {
        return -1;
    }
}
