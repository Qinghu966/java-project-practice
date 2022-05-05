package fr.epita.titanic.service;

import fr.epita.titanic.datamodel.Passenger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class PassengersDataService {

    public static final String SURVIVED_KEY = "survived";
    public static final String NOT_SURVIVED_KEY = "not-survived";

    public static Map<String, Integer> getPassengerCountBySurvival(List<Passenger> passengers) {
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
        return passengerCountBySurvival;
    }

    public static int getSurvivedCount(List<Passenger> passengers) {
        int survivedCount = 0;
        for (Passenger p : passengers) {
            if (p.getSurvived()) {
                survivedCount++;
            }
        }
        return survivedCount;
    }

    public static double getAverageAge(List<Passenger> passengers) {
        OptionalDouble average = passengers
                .stream()
                .mapToDouble(Passenger::getAge)
                .average();
        if (average.isPresent()) {
            System.out.println(average.getAsDouble());
            return average.getAsDouble();
        }
        return 0;
    }

    public static List<Passenger> readPassengerFromFile(File file) throws FileNotFoundException {
        if (file.exists()) {
            System.out.println("the file has been found!");
        }
        Scanner scanner = new Scanner(file);
        List<Passenger> passengers = new ArrayList<>();

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
                //do nothing or print a warning
            } else {
                passengers.add(passenger);
            }
        }
        scanner.close();
        return passengers;
    }

    public static void writeAsCsv(List<Passenger> passengers, String filePath) {
        File file = new File(filePath);
        try{
            file.createNewFile();
            PrintWriter printWriter = new PrintWriter(file);
            String header = "passengerId, gender, pclass, survived, age";
            printWriter.println(header);
            for(Passenger passenger : passengers){
                String csv = "";
                csv += passenger.getPassengerId() + ",";
                csv += passenger.getGender() + ",";
                csv += passenger.getPclass() + ",";
                csv += passenger.getSurvived() + ",";
                csv += passenger.getAge() + ",";

                printWriter.println(csv);
            }
            printWriter.flush();
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
