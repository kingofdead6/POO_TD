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

// Tattoo class
class Tattoo {
    private static int counter = 1;
    private final String label;

    public Tattoo(String animalName) {
        this.label = animalName + "#" + counter++;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tattoo)) return false;
        Tattoo tattoo = (Tattoo) o;
        return label.equals(tattoo.label);
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }
}

public class maps {
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
        // Step 1: Create TreeSet and populate
        Set<Animal> animalSet = new TreeSet<>();
        animalSet.add(new Animal("Lion"));
        animalSet.add(new Animal("Tiger"));
        animalSet.add(new Animal("Bear"));
        animalSet.add(new Animal("Cheetah"));

        // Step 1: Create ArrayList from TreeSet
        List<Animal> animalList = new ArrayList<>(animalSet);

        // Step 2: Add animals with same name and same instance
        Animal lionInstance = new Animal("Lion");
        animalList.add(new Animal("Tiger")); // Duplicate name
        animalList.add(new Animal("Cheetah")); // Duplicate name
        animalList.add(lionInstance); // Same instance
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

        // Step 5: Create a Map with Tattoo as key and Animal as value
        Map<Tattoo, Animal> animalMap = new HashMap<>();

        // Add entries for each animal in animalList
        for (Animal animal : animalList) {
            Tattoo tattoo = new Tattoo(animal.getName());
            animalMap.put(tattoo, animal);
        }

        // Step 6: Display entries using entrySet()
        System.out.println("\nMap entries (Tattoo -> Animal):");
        for (Map.Entry<Tattoo, Animal> entry : animalMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Step 7: Display keys separately
        System.out.println("\nMap keys (Tattoo):");
        for (Tattoo tattoo : animalMap.keySet()) {
            System.out.println(tattoo);
        }

        // Step 8: Display values separately
        System.out.println("\nMap values (Animals):");
        for (Animal animal : animalMap.values()) {
            System.out.println(animal);
        }
    }
}
