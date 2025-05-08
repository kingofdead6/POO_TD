import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
     
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        try {
            ParenthesizedExpression expr = new ParenthesizedExpression(in);
            System.out.println("Valid expression: " + expr.getExpression());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }   
    
}
