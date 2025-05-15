package passenger;
import train.Train;

public class Passenger {
    private final String name;

    public String getName() {
        return name;
    }

    public Passenger(String name) {
        this.name = name;
    }

    public void boardTrain(Train train) {
        System.out.println(name + " set on " + train.getInfo());
    }
}