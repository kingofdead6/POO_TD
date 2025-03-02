import java.util.ArrayList;
import java.util.List;

public class Screening {
    int screeningNumber;
    String date, startTime, endTime;
    double ticketPrice;
    Movie movie;
    List<Reservation> reservations;
    int bookedSeats;
    int totalSeats;

    public Screening(int screeningNumber, String date, String startTime, String endTime, double ticketPrice, Movie movie, int totalSeats) {
        this.screeningNumber = screeningNumber;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.ticketPrice = ticketPrice;
        this.movie = movie;
        this.reservations = new ArrayList<>();
        this.bookedSeats = 0;
        this.totalSeats = totalSeats;
    }

    public void bookSeat() {
        if (bookedSeats < totalSeats) {
            bookedSeats++;
        }
    }

    public boolean isFullyBooked() {
        return bookedSeats >= totalSeats;
    }
}