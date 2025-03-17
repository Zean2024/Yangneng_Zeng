package com.example;

import java.util.List;

public interface RaceResult {
    void recordResult(Driver driver, int position, int points);
    List<Driver> getRaceResults();
}


