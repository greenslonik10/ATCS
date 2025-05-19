package schedule;
import java.util.ArrayList;
import java.util.List;

import train.Train;

public class Schedule {
    private final List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return new ArrayList<>(trains);
    }

    public void addTrain(Train train) {
        if (train == null) {
            throw new IllegalArgumentException("Train cannot be null");
        }
        if (trains.contains(train)) {
            throw new IllegalStateException("Train already exists in schedule");
        }
        trains.add(train);
    }

        public boolean removeTrain(Train train) {
        return trains.remove(train);
    }

    public void showSchedule() {
        if (trains.isEmpty()) {
            System.out.println("Schedule is empty.");
        } else {
            System.out.println("Train schedule:");
            for (Train train : trains) {
                System.out.println(train.getInfo());
            }
        }
    }

    public Train findTrainByDestination(String destination) {
        for (Train train : trains) {
            if (train.getInfo().toLowerCase().contains(destination.toLowerCase())) {
                return train;
            }
        }
        return null;
    }
}