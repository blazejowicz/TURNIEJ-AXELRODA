package com.example.AxelrodTournamentApplication;

import com.example.AxelrodTournamentApplication.strategy.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AxelrodTournamentApplication {

    public static void main(String[] args) {
        SpringApplication.run(AxelrodTournamentApplication.class, args);
    }

    @RestController
    public class TournamentController {

        @GetMapping("/wyniki")
        public List<Map<String, Object>> getResults() {
            List<Strategy> strategie = new ArrayList<>();
            strategie.add(new AlwaysUnfair());
            strategie.add(new AlwaysFair());
            strategie.add(new RandomStrategy());
            strategie.add(new TitForTat());
            strategie.add(new GrimTrigger());
            strategie.add(new SingleCooperateThenAlwaysDefect());

            String[] nazwyStrategii = {
                "Niesprawiedliwa",
                "Sprawiedliwa",
                "Strategia Losowa",
                "Wet za Wet",
                "Grim Trigger",
                "Współpraca Potem Zdrada"
            };

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

            List<Map<String, Object>> wynikiList = new ArrayList<>();
            for (int i = 0; i < strategie.size(); i++) {
                int calkowityWynik = 0;
                for (int j = 0; j < strategie.size(); j++) {
                    calkowityWynik += wyniki[i][j];
                }
                Map<String, Object> wynik = new HashMap<>();
                wynik.put("nazwa", nazwyStrategii[i]);
                wynik.put("wynik", calkowityWynik);
                wynikiList.add(wynik);
            }
            return wynikiList;
        }
    }
}
