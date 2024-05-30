package com.example.AxelrodTournamentApplication;

public class PrisonersDilemma {
    public static int mojaKara(int mojaDecyzja, int jegoDecyzja) {
        if (mojaDecyzja == -1 && jegoDecyzja == -1) return 7;
        if (mojaDecyzja == 1 && jegoDecyzja == 1) return 3;
        if (mojaDecyzja == -1 && jegoDecyzja == 1) return 0;
        if (mojaDecyzja == 1 && jegoDecyzja == -1) return 10;
        return 0; // Nigdy nie powinno tu trafić
    }
}
