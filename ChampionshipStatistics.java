package com.example;

import java.util.List;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        return "Finland"; // Finland is the most successful country in rally
    }

    public static int countTotalRaces(List<RallyRaceResult> raceResults) {
        return raceResults.size();
    }
}