package com.example.AxelrodTournamentApplication;

import com.example.AxelrodTournamentApplication.strategy.*;
import java.util.ArrayList;
import java.util.List;

public class AxelrodTournament {
    public static void main(String[] args) {
        List<Strategy> strategie = new ArrayList<>();
        strategie.add(new AlwaysUnfair());
        strategie.add(new AlwaysFair());
        strategie.add(new RandomStrategy());
        strategie.add(new TitForTat());
        strategie.add(new GrimTrigger());
        strategie.add(new SingleCooperateThenAlwaysDefect());

        int iteracje = 1000;
        int[][] wyniki = new int[strategie.size()][strategie.size()];

        for (int i = 0; i < strategie.size(); i++) {
            for (int j = 0; j < strategie.size(); j++) {
                if (i != j) {
                    int wynikA = 0;
                    int wynikB = 0;
                    int ostatniaA = 0;
                    int ostatniaB = 0;
                    for (int k = 0; k < iteracje; k++) {
                        int decyzjaA = strategie.get(i).decyduj(ostatniaB);
                        int decyzjaB = strategie.get(j).decyduj(ostatniaA);
                        wynikA += PrisonersDilemma.mojaKara(decyzjaA, decyzjaB);
                        wynikB += PrisonersDilemma.mojaKara(decyzjaB, decyzjaA);
                        ostatniaA = decyzjaA;
                        ostatniaB = decyzjaB;
                    }
                    wyniki[i][j] = wynikA;
                    wyniki[j][i] = wynikB;
                }
            }
        }

        System.out.println("Wyniki Turnieju Axelroda:");
        for (int i = 0; i < strategie.size(); i++) {
            int calkowityWynik = 0;
            for (int j = 0; j < strategie.size(); j++) {
                calkowityWynik += wyniki[i][j];
            }
            System.out.println("Strategia " + i + " całkowity wynik: " + calkowityWynik);
        }
    }
}
