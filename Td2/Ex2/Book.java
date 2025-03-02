package Ex2;

// Book class, a borrowable resource with an author and number of pages
public class Book extends Resource {
    private String author;
    private int numPages;

    public Book(String title, String author, int numPages) {
        super(title);
        this.author = author;
        this.numPages = numPages;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Author: " + author);
        System.out.println("Number of pages: " + numPages);
    }
}

