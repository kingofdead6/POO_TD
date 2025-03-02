
public class Reservation {
    int reservationNumber;
    Customer customer;
    Screening screening;
    boolean used;

    public Reservation(int reservationNumber, Customer customer, Screening screening) {
        this.reservationNumber = reservationNumber;
        this.customer = customer;
        this.screening = screening;
        this.used = false;
    }

    public void markAsUsed() {
        this.used = true;
    }
}
