package fr.epita.titanic.launchers;

import fr.epita.titanic.datamodel.Passenger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Launcher {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./titanic/titanic.csv");
        if (file.exists()) {
            System.out.println("the file has been found!");
        }
        Scanner scanner = new Scanner(file);
        List<Passenger> passengers = new ArrayList<>();
        List<Passenger> invalidPassengers = new ArrayList<>();
        double averageAge = 0;
        //we want to skip the headers row.
        scanner.nextLine();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");

            String passengerId = split[0];
            Boolean survived = split[1].equals("1");
            String pclass = split[2];
            String gender = split[3];

            String rawAge = split[4];
            double age = 0;
            boolean invalidAge = rawAge == null || rawAge.isEmpty();
            if (!invalidAge) {
                age = Double.parseDouble(rawAge);
            }

            Passenger passenger = new Passenger(passengerId, survived, pclass, gender, age);
            if (invalidAge) {
                invalidPassengers.add(passenger);
            } else {
                passengers.add(passenger);
                averageAge += passenger.getAge();
            }
        }
        averageAge = averageAge / passengers.size();
        int survivedCount = 0;
        for (Passenger p : passengers) {
            if (p.getSurvived()) {
                survivedCount++;
            }
        }
        long survivedPassengersCount = passengers.stream()
                .filter(passenger -> passenger.getSurvived())
                .count();

        System.out.println("survived " + survivedCount + " out of " + passengers.size());
        double average = passengers
                .stream()
                .mapToDouble(Passenger::getAge)
                .average()
                .getAsDouble();

        System.out.println("average: " + average);

        Map<String, Integer> passengerCountBySurvival = new HashMap<>();
        for (Passenger passenger : passengers) {
            if (passenger.getSurvived()) {
                Integer count = passengerCountBySurvival.get("survived");
                if (count == null) {
                    count = 0;
                }
                passengerCountBySurvival.put("survived", count + 1);
            } else {
                Integer count = passengerCountBySurvival.get("not-survived");
                if (count == null) {
                    count = 0;
                }
                passengerCountBySurvival.put("not-survived", count + 1);
            }
        }
        System.out.println(passengerCountBySurvival);
    }
}