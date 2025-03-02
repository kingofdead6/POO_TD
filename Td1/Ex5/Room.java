import java.util.ArrayList;
import java.util.List;

public class Room {
    int number, capacity;
    List<Screening> screenings;

    public Room(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }
}
