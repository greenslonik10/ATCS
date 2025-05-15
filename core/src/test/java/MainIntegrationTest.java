import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import passenger.Passenger;
import schedule.Schedule;
import train.Train;

class MainIntegrationTest {

    @Test
    void testCompleteScenario() {
        Schedule schedule = new Schedule();
        Train train1 = new Train("Moscow", "10:30");
        Train train2 = new Train("Saint-Petersburg", "12:45");
        
        schedule.addTrain(train1);
        schedule.addTrain(train2);
        
        assertEquals(2, schedule.getTrains().size());
        
        Passenger passenger = new Passenger("Test Passenger");
        assertDoesNotThrow(() -> passenger.boardTrain(train1));
        
        Train found = schedule.findTrainByDestination("Petersburg");
        assertNotNull(found);
        assertEquals(train2.getInfo(), found.getInfo());
        
        assertTrue(schedule.removeTrain(train1));
        assertEquals(1, schedule.getTrains().size());
    }
}