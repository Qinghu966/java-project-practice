import fr.epita.titanic.datamodel.Passenger;
import fr.epita.titanic.service.PassengersDataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class TestPassengersDataService {

    public static void main(String[] args) throws FileNotFoundException {
        whenCsvContainsValidPassengers_ThenReturedListSizeIs3();
    }

    private static void whenCsvContainsValidPassengers_ThenReturedListSizeIs3() throws FileNotFoundException {
        //given
        File fileContains3Entries = new File("./titanic/test/samplePassengers.csv");

        // when
        List<Passenger> passengers = PassengersDataService.readPassengerFromFile(new File("./titanic/test/samplePassengers.csv"));

        //then
        assert passengers.size() == 3;
    }

    private static void whenFileDoseNotExistThenAnExceptionIsThrown(){
        Exception e = null;
        try {
            PassengersDataService.readPassengerFromFile(new File(("abc")));
        } catch (FileNotFoundException fe) {
            e = fe;
        }
        assert e != null;
    }

}
