
import java.util.List;

public class Movie {
    String title, director, synopsis;
    int productionYear;
    List<String> actors;

    public Movie(String title, int productionYear, String director, List<String> actors, String synopsis) {
        this.title = title;
        this.productionYear = productionYear;
        this.director = director;
        this.actors = actors;
        this.synopsis = synopsis;
    }

    public void displayInfo() {
        System.out.println("---------------------------------");
        System.out.println("Title: " + title);
        System.out.println("Production Year: " + productionYear);
        System.out.println("Director: " + director);
        System.out.println("Actors: " + String.join(", ", actors));
        System.out.println("Synopsis: " + synopsis);
        System.out.println("---------------------------------");
    }
}
