package com.example;

import java.util.*;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private Map<Driver, Integer> results; // record the drivers and their points
    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
        this.results = new HashMap<>();
    }

    @Override
    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points); // record the poins for the driver
        driver.addPoints(points); // add the points to the driver
    }

    @Override
    public List<Driver> getRaceResults() {
        // sort the drivers by their points
        List<Driver> sortedDrivers = new ArrayList<>(results.keySet());
        sortedDrivers.sort((d1, d2) -> results.get(d2) - results.get(d1)); // sort the drivers by their points
        return sortedDrivers;
    }

    public String getRaceName() {
        return raceName;
    }

    public Map<Driver, Integer> getResults() {
        return results;
    }
}