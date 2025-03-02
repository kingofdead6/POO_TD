package Ex2;

// Magazine class, not borrowable, with issue number
public class Magazine extends Document {
    private int issue;

    public Magazine(String title, int issue) {
        super(title);
        this.issue = issue;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Issue: " + issue);
    }
}
