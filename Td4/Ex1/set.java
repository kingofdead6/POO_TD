import java.util.*;

class Animal implements Comparable<Animal> {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return name.equals(animal.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Animal other) {
        return this.name.compareTo(other.name);
    }
}

// Main class
public class set {
    public static void main(String[] args) {
        Set<Animal> animals = new TreeSet<>();
        animals.add(new Animal("Lion"));
        animals.add(new Animal("Tiger"));
        animals.add(new Animal("Bear"));

        System.out.println("Initial set of animals:");
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        animals.add(new Animal("Lion"));
        animals.add(new Animal("Tiger"));
        animals.add(new Animal("Lion"));

        System.out.println("\nSet after adding duplicates:");
        iterator = animals.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}