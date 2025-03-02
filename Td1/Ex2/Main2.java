package Ex2;
import java.util.Scanner;
public class Main2 {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the x coordinate: ");
        int x = scanner.nextInt();
        System.out.println("Enter the y coordinate: ");
        int y = scanner.nextInt();
        Point p = new Point(x, y);
        p.display();
        scanner.close();
    }
}
