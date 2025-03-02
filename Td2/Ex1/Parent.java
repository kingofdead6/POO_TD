class Parent extends GrandParent {

    private int x = 20;
    public int y = 40;

    public Parent(int x, int y) {
        super(x); // Call the GrandParent constructor
        this.y = y;
    }

    //  the function cannot be returning int cause it exists in GrandParent and its void 
    @Override
    public void add(int a, int b) {
        x = x + a;
        y = y + b;
        //return x + y;
        // return should be removed 
    }
 
    @Override
    public void display() {  //  Change to public
       System.out.println("GrandParent x: " + getX()); // a getter is added to access x
       System.out.println("GrandParent y: " + super.y); //it gets it from the grandparent
       System.out.println("Parent x: " + x);
       System.out.println("Parent y: " + y);
    }
}