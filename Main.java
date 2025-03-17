package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // create rally cars and drivers
        RallyCar gravelCar = new GravelCar("Toyota", "Yaris", 300);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20", 320);

        Driver driver1 = new Driver("Sébastien Ogier", "France", gravelCar);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", asphaltCar);
        Driver driver3 = new Driver("Ott Tänak", "Estonia", gravelCar);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        // register drivers
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        // simulate rally
        RallyRaceResult race1 = new RallyRaceResult("Rally Finland");
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);
        manager.recordRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally");
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);
        manager.recordRaceResult(race2);

        // print championship standings
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        for (Driver driver : manager.getDrivers()) {
            System.out.println(driver.getName() + " (" + driver.getCountry() + "): " + driver.getTotalPoints() + " points");
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = manager.getLeadingDriver();
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getDrivers().size());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRaces(manager.getRaceResults()));
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getDrivers()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getDrivers()));
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : manager.getRaceResults()) {
            System.out.println("Race: " + race.getRaceName());
            List<Driver> sortedDrivers = race.getRaceResults(); 
            for (int i = 0; i < sortedDrivers.size(); i++) {
                Driver driver = sortedDrivers.get(i);
                int racePoints = race.getResults().get(driver);
                System.out.println("    Position " + (i + 1) + ": " + driver.getName() + " - " + racePoints + " points");
            }
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}