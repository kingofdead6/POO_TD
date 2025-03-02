package Ex2;
// Base class for all documents
public class Document {
    protected String title;

    public Document(String title) {
        this.title = title;
    }

    public void display() {
        System.out.println("Title: " + title);
    }
}
