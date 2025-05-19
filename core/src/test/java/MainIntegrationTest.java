import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import passenger.Passenger;
import schedule.Schedule;
import train.Train;

class MainIntegrationTest {

    private Train mockTrain1;
    private Train mockTrain2;

    @BeforeEach
    void setUp() {
        mockTrain1 = mock(Train.class);
        mockTrain2 = mock(Train.class);

        when(mockTrain1.getInfo()).thenReturn("Train to Moscow starts in 10:30");
        when(mockTrain2.getInfo()).thenReturn("Train to Saint-Petersburg starts in 12:45");
    }

    @Test
    void testCompleteScenarioWithMocks() {
        Schedule schedule = new Schedule();

        schedule.addTrain(mockTrain1);
        schedule.addTrain(mockTrain2);

        assertEquals(2, schedule.getTrains().size());

        Passenger passenger = new Passenger("Test Passenger");

        assertDoesNotThrow(() -> passenger.boardTrain(mockTrain1));
        verify(mockTrain1, atLeastOnce()).getInfo();

        Train found = schedule.findTrainByDestination("Petersburg");
        assertNotNull(found);
        assertEquals(mockTrain2.getInfo(), found.getInfo());

        assertTrue(schedule.removeTrain(mockTrain1));
        assertEquals(1, schedule.getTrains().size());

        assertEquals("Train to Saint-Petersburg starts in 12:45", schedule.getTrains().get(0).getInfo());
    }
}
