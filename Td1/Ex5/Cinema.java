
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    String name, address;
    List<Room> rooms;
    List<Customer> customers;
    List<Reservation> reservations;
    int nextReservationNumber;

    public Cinema(String name, String address) {
        this.name = name;
        this.address = address;
        this.rooms = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.nextReservationNumber = 1;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void displayCustomers() {
        for (Customer customer : customers) {
            System.out.println("Customer Number: " + customer.customerNumber + ", Name: " + customer.name + " Number of Past Screenings : "+customer.pastScreeningsCount);
            System.out.println("---------------------------------");

        }
    }

    public Customer findCustomer(int customerNumber) {
        for (Customer customer : customers) {
            if (customer.customerNumber == customerNumber) {
                return customer;
            }
        }
        return null;
    }

    public Screening findScreening(int screeningNumber) {
        for (Room room : rooms) {
            for (Screening screening : room.screenings) {
                if (screening.screeningNumber == screeningNumber) {
                    return screening;
                }
            }
        }
        return null;
    }

    public void makeReservation(int customerNumber, int screeningNumber) {
        Customer customer = findCustomer(customerNumber);
        if (customer == null) {
            System.out.println("Invalid customer number.");
            System.out.println("---------------------------------");

            return;
        }

        Screening screening = findScreening(screeningNumber);
        if (screening == null) {
            System.out.println("Invalid screening.");
            System.out.println("---------------------------------");
            return;
        } else if (screening.isFullyBooked()) {
            System.out.println("Fully booked screening.");
            System.out.println("---------------------------------");
            return;
        }

        double ticketPrice = screening.ticketPrice;
        if (customer.hasDiscount()) {
            ticketPrice *= 0.95; ;
        }

        Reservation reservation = new Reservation(nextReservationNumber++, customer, screening);
        reservations.add(reservation);
        customer.addReservation(reservation);
        screening.bookSeat();

        System.out.println("Reservation confirmed. Reservation Number: " + reservation.reservationNumber + ", Ticket Price: $" + ticketPrice);
        System.out.println("---------------------------------");

    }

    public void validateReservation(int reservationNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.reservationNumber == reservationNumber) {
                if (reservation.used) {
                    System.out.println("Reservation already used.");
                    System.out.println("---------------------------------");

                } else {
                    reservation.markAsUsed();
                    reservation.customer.incrementScreeningsCount();
                    System.out.println("Reservation validated.");
                    System.out.println("---------------------------------");

                }
                return;
            }
        }
        System.out.println("Invalid reservation number.");
        System.out.println("---------------------------------");

    }
}