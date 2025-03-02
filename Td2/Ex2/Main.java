package Ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of various resources
        List<Document> resources = new ArrayList<>();
        resources.add(new Book("Java Programming", "John Doe", 500));
        resources.add(new Magazine("Tech Monthly", 12));
        resources.add(new DVD("Inception", 148));

        // Display all resources
        for (Document doc : resources) {
            doc.display();
            System.out.println("----------------------");
        }

        // Borrow and return a book
        if (resources.get(0) instanceof Resource) {
            ((Resource) resources.get(0)).borrow();
            ((Resource) resources.get(0)).returnResource();
        }
    }
}



/*
 * The output of the program is :  
 * Title: Java Programming
 * Borrowed: false
 * Author: John Doe
 * Number of pages: 500
 * ----------------------
 * Title: Tech Monthly
 * Issue: 12
 * ----------------------
 * Title: Inception
 * Borrowed: false
 * Duration: 148 minutes
 * ----------------------
 * Java Programming has been borrowed.
 * Java Programming has been returned.
 */