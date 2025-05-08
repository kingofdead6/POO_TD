package Ex3; // Define the package name

public class Main {
    public static void main(String[] arg) {
        byte bb = 1;
        short p = 2;
        int n = 3;
        long q = 4;
        float x = 5.f;
        double y = 6.;

        System.out.println("** A **");
        A a = new A();
        a.f(bb);
        a.f(x);
        a.f(y);

        System.out.println("** B **");
        
        B b = new B();
        b.f(bb);
        b.f(x);
        b.f(n);
        System.out.println();

        a = b;
        a.f(bb);
        a.f(x);
        a.f(n);

        System.out.println("** C **");
        C c = new C();
        c.f(bb);
        c.f(q);
        c.f(x);
        c.f(n, bb);
        System.out.println();

        a = c;
        a.f(bb);
        a.f(q);
        a.f(x);

        System.out.println("** D **");
        D d = new D();
        d.f(bb);
        d.f(q);
        d.f(y);
        System.out.println();

        a = d;
        a.f(bb);
        a.f(q);
        a.f(y);

        System.out.println("** F **");
        F f = new F();
        f.f(bb);
        f.f(n);
        f.f(x);
        f.f(y);
        f.f(n, x);
    //    f.f(n, bb);
        System.out.println();

        a = f;
        a.f(bb);
        a.f(n);
        a.f(x);
        a.f(y);
        System.out.println();

        c = f;
        c.f(bb);
        c.f(n);
        c.f(x);
        c.f(y);
        System.out.println();

        c.f(n, bb);
            //    ((F) d).f(n, bb);
        ((C) f).f(n, bb);
        ((C) f).f(n);
        ((C) f).f(x);
    }
}
