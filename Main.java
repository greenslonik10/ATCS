// Задача: Создать систему для управления расписанием поездов, где можно добавлять поезда
//         и выводить их расписание.

public class Main {
    public static void main(String[] args) {
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
    }
}