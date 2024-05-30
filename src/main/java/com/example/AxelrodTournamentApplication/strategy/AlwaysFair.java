package com.example.AxelrodTournamentApplication.strategy;

public class AlwaysFair implements Strategy {
    public int decyduj(int ostatniaDecyzjaPrzeciwnika) {
        return 1;
    }
}
