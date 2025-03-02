class GrandParent {
    private int x = 10;
    protected int y = 30;

    public GrandParent(int x) {
         this.x = x; 
    }

    public void add(int a, int b) {
        x = x + a;
        y = y + b; 
    }
    public void printMethod() {
        System.out.println("Print method in GrandParent"); 
    }

    // the getter should be added to access x 
    public int getX() {
        return x;
    }

    public void display (){
        System.out.println("GrandParent x: " + x);
        System.out.println("GrandParent y: " + y);
    }
}