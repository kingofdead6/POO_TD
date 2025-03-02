package Ex3; // Define the package name

public class C extends A {
    public void f(long q) {
        System.out.println("C.f(long=" + q + ")");
    }

    public void f(float x, int n) {
        System.out.println("C.f(float=" + x + ", int=" + n + ")");
    }
}
