class Child extends Parent {
    private int x = 50;
    private int z;

    // there is no constructor for the child
    public Child(int x, int y, int z) {
        super(x,y);
        this.z = z;
    }
    @Override
    public void display() {
        super.display();
        System.out.println("Child x: " + x);
        System.out.println("Child z: " + z);
        System.out.println("Child y: " + y); 
    }
        //it should be public 
    public void printMethod() {
        System.out.println("Print method in Child"); 
    }
    @Override
    public void add(int a, int b) {  // this should be public
        x = x + a;
        y = y + b;
     }
 }