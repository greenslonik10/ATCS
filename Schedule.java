import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private final List<Train> trains = new ArrayList<>();

    public void addTrain(Train train) {
        trains.add(train);
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