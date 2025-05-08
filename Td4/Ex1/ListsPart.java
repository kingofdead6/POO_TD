import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// Animal class
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

public class ListsPart {
    public static void printAnimalsStartingWithC(Collection<Animal> animals) {
        Iterator<Animal> iterator = animals.iterator();
        System.out.println("Animals with names starting with 'C':");
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.getName().startsWith("C")) {
                System.out.println(animal);
            }
        }
    }

    public static void main(String[] args) {
        Set<Animal> animalSet = new TreeSet<>();
        animalSet.add(new Animal("Lion"));
        animalSet.add(new Animal("Tiger"));
        animalSet.add(new Animal("Bear"));
        animalSet.add(new Animal("Cheetah")); 

        List<Animal> animalList = new ArrayList<>(animalSet);

        Animal lionInstance = new Animal("Lion");
        animalList.add(new Animal("Tiger")); 
        animalList.add(new Animal("Cheetah"));
        animalList.add(lionInstance); 
        animalList.add(lionInstance); // Same instance again

        // Display the list
        System.out.println("Animal list after adding duplicates and same instances:");
        for (Animal animal : animalList) {
            System.out.println(animal);
        }

        // Step 3: Test printAnimalsStartingWithC with set and list
        System.out.println("\nTesting with animal set:");
        printAnimalsStartingWithC(animalSet);

        System.out.println("\nTesting with animal list:");
        printAnimalsStartingWithC(animalList);

        // Step 4: Sort the list and display
        Collections.sort(animalList);
        System.out.println("\nSorted animal list:");
        for (Animal animal : animalList) {
            System.out.println(animal);
        }
    }
}