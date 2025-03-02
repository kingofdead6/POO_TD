
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Creating movies
        Movie movie1 = new Movie("Inception", 2010, "Christopher Nolan", Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"), "A mind-bending thriller");
        Movie movie2 = new Movie("Interstellar", 2014, "Christopher Nolan", Arrays.asList("Matthew McConaughey", "Anne Hathaway"), "A space exploration epic");

        // Creating rooms
        Room room1 = new Room(1, 100);
        Room room2 = new Room(2, 80);
        Room room3 = new Room(3, 120);

        // Adding screenings
        room1.addScreening(new Screening(1, "2025-02-20", "14:00", "16:30", 10.0, movie1, 10));
        room1.addScreening(new Screening(2, "2025-02-20", "19:00", "21:30", 10.0, movie1, 100));

        room2.addScreening(new Screening(3, "2025-02-20", "14:00", "16:30", 10.0, movie2, 80));
        room2.addScreening(new Screening(4, "2025-02-20", "19:00", "21:30", 10.0, movie2, 80));

        // Creating cinema
        Cinema cinema = new Cinema("Grand Cinema", "123 Street, City");
        cinema.addRoom(room1);
        cinema.addRoom(room2);
        cinema.addRoom(room3);

        // Register customers
        Customer customer1 = new Customer(1, "John Doe");
        Customer customer2 = new Customer(2, "Jane Smith");
        Customer customer3 = new Customer(3, "Alice Johnson");
        customer3.pastScreeningsCount = 30; // Customer with more than 25 past screenings
        cinema.registerCustomer(customer1);
        cinema.registerCustomer(customer2);
        cinema.registerCustomer(customer3);

        // Display screenings
        for (Room room : cinema.rooms) {
            for (Screening screening : room.screenings) {
                System.out.println("Room " + room.number + " screening " + screening.screeningNumber + " - Movie: " + screening.movie.title + "  date  " + screening.date + "  Starts at  " + screening.startTime + "  Ends at  " + screening.endTime + "  ticket Price: " + screening.ticketPrice + "$");
            }
        }

        // Display movie Information
        movie1.displayInfo();
        movie2.displayInfo();

        // Display registered customers
        cinema.displayCustomers();

        // Test reservations
        cinema.makeReservation(1, 1); // Valid reservation, full price
        cinema.makeReservation(2, 3); // Valid reservation, full price
        cinema.makeReservation(3, 2); // Valid reservation, with discount
        cinema.makeReservation(4, 1); // Invalid customer number
        cinema.makeReservation(1, 5); // Invalid screening number

        // Fully book a screening
        for (int i = 0; i < 10; i++) {
            cinema.makeReservation(1, 1);
        }
        cinema.makeReservation(2, 1); // Fully booked screening

        // Validate reservations
        cinema.validateReservation(1); // Valid reservation
        cinema.validateReservation(1); // Already used reservation
        cinema.validateReservation(999); // Non-existent reservation
    }
}
