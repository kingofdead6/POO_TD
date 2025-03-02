package Ex3; // Define the package name

public class F extends C {
    public void f(double x) {
        System.out.println("F.f(double=" + x + ")");
    }

    public void f(int n) {
        System.out.println("F.f(int=" + n + ")");
    }

    public void f(int n, float x) {
        System.out.println("F.f(int=" + n + ", float=" + x + ")");
    }
}
