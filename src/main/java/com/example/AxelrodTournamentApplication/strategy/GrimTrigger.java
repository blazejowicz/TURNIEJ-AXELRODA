package com.example.AxelrodTournamentApplication.strategy;

public class GrimTrigger implements Strategy {
    private boolean zdradzony = false;

    public int decyduj(int ostatniaDecyzjaPrzeciwnika) {
        if (ostatniaDecyzjaPrzeciwnika == -1) {
            zdradzony = true;
        }
        return zdradzony ? -1 : 1;
    }
}
