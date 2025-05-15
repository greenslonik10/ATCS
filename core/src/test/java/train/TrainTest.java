package train;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    void testTrainCreation() {
        Train train = new Train("Moscow", "10:30");
        assertNotNull(train);
        assertEquals("Train to Moscow starts in 10:30", train.getInfo());
    }

    @Test
    void testGetInfo() {
        Train train = new Train("Saint-Petersburg", "12:45");
        String expected = "Train to Saint-Petersburg starts in 12:45";
        assertEquals(expected, train.getInfo());
    }
}