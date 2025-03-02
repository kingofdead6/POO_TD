package Ex2;

public class Point {
    private int x ;
    private int y ;
    public Point(int absc , int ord){
        x = absc ;
        y = ord ;
    }
    public void move(int dx , int dy){
        x += dx ;
        y += dy ;
    }
    public void display(){
        System.out.println("Coordonates are  : (" + x + "," + y + ")");
    }
}

