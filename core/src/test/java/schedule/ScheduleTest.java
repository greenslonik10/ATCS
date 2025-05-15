package schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import train.Train;
import static org.junit.jupiter.api.Assertions.*;

class ScheduleTest {
    private Schedule schedule;
    private Train train1;
    private Train train2;

    @BeforeEach
    void setUp() {
        schedule = new Schedule();
        train1 = new Train("Moscow", "10:30");
        train2 = new Train("Saint-Petersburg", "12:45");
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
    void testFindTrainByDestination() {
        schedule.addTrain(train1);
        schedule.addTrain(train2);
        
        Train found = schedule.findTrainByDestination("Moscow");
        assertNotNull(found);
        assertEquals(train1.getInfo(), found.getInfo());
    }

    @Test
    void testFindNonExistentTrain() {
        assertNull(schedule.findTrainByDestination("Non-existent"));
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
}