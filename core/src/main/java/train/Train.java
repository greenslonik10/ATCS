package train;

public class Train {
    private final String destination;
    private final String departureTime;

    public Train(String destination, String departureTime) {
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getInfo() {
        return "Train to " + destination + " starts in " + departureTime;
    }
}