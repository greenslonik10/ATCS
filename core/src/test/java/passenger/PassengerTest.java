package passenger;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import train.Train;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PassengerTest {

    @Test
    void testPassengerCreation() {
        Passenger passenger = new Passenger("John Doe");
        assertNotNull(passenger);
        assertEquals("John Doe", passenger.getName());
    }

    @Test
    void testBoardTrain() {
        Train mockTrain = Mockito.mock(Train.class);
        when(mockTrain.getInfo()).thenReturn("MockTrain to Berlin at 09:00");

        Passenger passenger = new Passenger("Alice");

        assertDoesNotThrow(() -> passenger.boardTrain(mockTrain));

        verify(mockTrain, times(1)).getInfo();
    }
}

