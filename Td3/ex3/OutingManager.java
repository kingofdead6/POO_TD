package ex3;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class OutingManager {
    private Outing[] outings;
    private int count;

    public OutingManager() {
        outings = new Outing[10];
        count = 0;
    }

    public void addOuting(Outing newOuting) throws Exception {
        if (count >= 10) {
            throw new Exception("Cannot add more than 10 outings.");
        }

        for (int i = 0; i < count; i++) {
            if (outings[i].getDateTime().equals(newOuting.getDateTime())) {
                throw new Exception("Another outing is already scheduled at this date and time.");
            }
        }

        outings[count++] = newOuting;
    }

    public ArrayList<Outing> getOutingsBetween(LocalDateTime start, LocalDateTime end) {
        ArrayList<Outing> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LocalDateTime dt = outings[i].getDateTime();
            if (!dt.isBefore(start) && !dt.isAfter(end)) {
                result.add(outings[i]);
            }
        }
        return result;  
    }

    public ArrayList<Outing> getAllOutings() {
        ArrayList<Outing> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(outings[i]);
        }
        return result;
    }
}