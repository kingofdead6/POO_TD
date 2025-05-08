package ex3;

import java.time.LocalDateTime;

public class Outing {
    private String name;
    private String location;
    private LocalDateTime dateTime;

    public Outing(String name, String location, LocalDateTime dateTime) {
        this.name = name;
        this.location = location;
        this.dateTime = dateTime;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String toString() {
        return "Outing: " + name + " | Location: " + location + " | Date & Time: " + dateTime;
    }
}