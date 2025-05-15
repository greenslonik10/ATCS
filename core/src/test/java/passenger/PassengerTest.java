package passenger;

import org.junit.jupiter.api.Test;
import train.Train;
import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void testPassengerCreation() {
        Passenger passenger = new Passenger("John Doe");
        assertNotNull(passenger);
        assertEquals("John Doe", passenger.getName());
    }

    @Test
    void testBoardTrain() {
        Passenger passenger = new Passenger("Alice");
        Train train = new Train("Paris", "08:15");
        
        assertDoesNotThrow(() -> passenger.boardTrain(train));
    }
}