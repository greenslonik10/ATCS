package schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import train.Train;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ScheduleTest {
    private Schedule schedule;
    private Train train1;
    private Train train2;

    @BeforeEach
    void setUp() {
        schedule = new Schedule();

        train1 = mock(Train.class);
        when(train1.getInfo()).thenReturn("Moscow - 10:30");

        train2 = mock(Train.class);
        when(train2.getInfo()).thenReturn("Saint-Petersburg - 12:45");
    }

    @Test
    void testAddTrain() {
        schedule.addTrain(train1);
        assertEquals(1, schedule.getTrains().size());
    }

    @Test
    void testAddNullTrain() {
        assertThrows(IllegalArgumentException.class, () -> schedule.addTrain(null));
    }

    @Test
    void testAddDuplicateTrain() {
        schedule.addTrain(train1);
        assertThrows(IllegalStateException.class, () -> schedule.addTrain(train1));
    }

    @Test
    void testShowEmptySchedule() {
        assertDoesNotThrow(() -> schedule.showSchedule());
    }

    @Test
    void testShowScheduleWithTrains() {
        schedule.addTrain(train1);
        schedule.addTrain(train2);
        assertDoesNotThrow(() -> schedule.showSchedule());

        verify(train1, times(1)).getInfo();
        verify(train2, times(1)).getInfo();
    }

    @Test
    void testFindTrainByDestination() {
        schedule.addTrain(train1);
        schedule.addTrain(train2);

        Train found = schedule.findTrainByDestination("Moscow");
        assertNotNull(found);
        assertEquals(train1.getInfo(), found.getInfo());
    }

    @Test
    void testFindNonExistentTrain() {
        schedule.addTrain(train1);
        Train found = schedule.findTrainByDestination("Paris");
        assertNull(found);
    }

    @Test
    void testRemoveTrain() {
        schedule.addTrain(train1);
        assertTrue(schedule.removeTrain(train1));
        assertEquals(0, schedule.getTrains().size());
    }

    @Test
    void testRemoveNonExistentTrain() {
        assertFalse(schedule.removeTrain(train1));
    }

    @Test
    void testGetTrainsReturnsCopy() {
        schedule.addTrain(train1);
        List<Train> original = schedule.getTrains();
        original.clear(); // пытаемся изменить список

        assertEquals(1, schedule.getTrains().size(), "getTrains() должен возвращать копию, а не оригинал");
    }
}
