package com.example.AxelrodTournamentApplication.strategy;

public class SingleCooperateThenAlwaysDefect implements Strategy {
    private boolean pierwszyRuch = true;

    public int decyduj(int ostatniaDecyzjaPrzeciwnika) {
        if (pierwszyRuch) {
            pierwszyRuch = false;
            return 1;
        }
        return -1;
    }
}
