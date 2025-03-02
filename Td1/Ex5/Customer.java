
import java.util.ArrayList;
import java.util.List;

public class Customer {
    int customerNumber;
    String name;
    int pastScreeningsCount;
    List<Reservation> reservations;

    public Customer(int customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.pastScreeningsCount = 0;
        this.reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public boolean hasDiscount() {
        return pastScreeningsCount > 25;
    }

    public void incrementScreeningsCount() {
        pastScreeningsCount++;
    }
}
