package Ex2;

// Abstract class for borrowable resources
public abstract class Resource extends Document {
    protected boolean borrowed;

    public Resource(String title) {
        super(title);
        this.borrowed = false;
    }

    public void borrow() {
        if (!borrowed) {
            borrowed = true;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnResource() {
        if (borrowed) {
            borrowed = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Borrowed: " + borrowed);
    }
}
