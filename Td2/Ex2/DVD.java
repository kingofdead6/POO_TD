package Ex2;

// DVD class, a borrowable resource with duration
public class DVD extends Resource {
    private int duration; 

    public DVD(String title, int duration) {
        super(title);
        this.duration = duration;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Duration: " + duration + " minutes");
    }
}
