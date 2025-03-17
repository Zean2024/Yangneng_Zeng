package com.example;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> raceResults;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        raceResults = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void recordRaceResult(RallyRaceResult result) {
        raceResults.add(result);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<RallyRaceResult> getRaceResults() {
        return raceResults;
    }

    public Driver getLeadingDriver() {
        return drivers.stream()
                .max((d1, d2) -> Integer.compare(d1.getTotalPoints(), d2.getTotalPoints()))
                .orElse(null);
    }

    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }
}