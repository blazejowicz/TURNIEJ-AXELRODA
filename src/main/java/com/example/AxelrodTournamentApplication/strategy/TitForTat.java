package com.example.AxelrodTournamentApplication.strategy;

public class TitForTat implements Strategy {
    public int decyduj(int ostatniaDecyzjaPrzeciwnika) {
        if (ostatniaDecyzjaPrzeciwnika == 0) return 1; // Pierwszy ruch jest uczciwy
        return ostatniaDecyzjaPrzeciwnika;
    }
}
