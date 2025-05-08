package ex1;

public class Main {
    static class NegativeNumber extends Exception {
        public NegativeNumber(String message) {
            super(message);
        }
    }

    static class NumberTooLarge extends Exception {
        public NumberTooLarge(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new ArrayIndexOutOfBoundsException();
            }

            int number;
            try {
                number = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("The argument must be an integer");
            }

            if (number < 0) throw new NegativeNumber("The integer is negative, factorial is undefined");
        
            if (number > 25) throw new NumberTooLarge("The entered integer is too large");
            
            long result = Fact(number);
            System.out.println("Factorial of " + number + " is: " + result);


        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide an integer as a command-line argument");
            System.exit(1);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (NegativeNumber e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (NumberTooLarge e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private static long Fact(int n) {
        return (n <= 1) ? 1 : n * Fact(n - 1);
    }
}