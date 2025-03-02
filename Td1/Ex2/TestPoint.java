package Ex2;

public class TestPoint {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        Point p = new Point(x,y);
        p.display();
        p.move(2, 3);
        p.display();
    }
    
}
/* the list of commands to compile and run the program
   * javac -d . Ex2/TestPoint.java 
   * javac -d . Ex2/Point.java Ex2/TestPoint.java
   * java Ex2.TestPoint 5 10
*/