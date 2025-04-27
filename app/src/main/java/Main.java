// Задача: Создать систему для управления расписанием поездов, где можно добавлять поезда
//         и выводить их расписание.

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import passenger.Passenger;
import schedule.Schedule;
import train.Train;



public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Applicaton up!");
        Schedule schedule = new Schedule();

        Train train1 = new Train("Moscow", "10:30");
        Train train2 = new Train("Saint-Petersburg", "12:45");

        schedule.addTrain(train1);
        schedule.addTrain(train2);

        Passenger passenger1 = new Passenger("Nikita");

        Train train3 = schedule.findTrainByDestination("Moscow");

        schedule.addTrain(train3);

        schedule.showSchedule();
        passenger1.boardTrain(train2);
        logger.info("Applicaton exicuted succesfully!");
    }
}