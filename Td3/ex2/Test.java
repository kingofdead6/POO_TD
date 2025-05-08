package ex2;

public class Test {
    public static void main(String[] args) {
        // ! 1. Employee with salary that does not exceed ceiling
        Fonctionnaire f1 = new Fonctionnaire("Ali", "Benaissa", 150000);
        try {
            System.out.println("Old Salary : " + f1.getSalary());
            double newSalary = f1.augmenterSalaire(f1.getSalary(), 20); // * 20% increase
            System.out.println("New Salary : " + newSalary);
        } catch (AugmentationImpossibleException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("----------------");

        // ! 2. Employee with salary that exceeds ceiling
        Fonctionnaire f2 = new Fonctionnaire("Sara", "Yahia", 190000);
        try {
            System.out.println("Old Salary : " + f2.getSalary());
            double newSalary = f2.augmenterSalaire(f2.getSalary(), 10); // * 10% increase
            System.out.println("New Salary : " + newSalary);
        } catch (AugmentationImpossibleException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("----------------");

        // ! 3. ChefService with increase but not limited by ceiling
        ChefService cs = new ChefService("Rami", "Mokhtar", 195000, "IT");
        System.out.println("Old Salary : " + cs.getSalary());
        double newCS = cs.augmenterSalaire(); // * Fixed 15% increase, no ceiling
        System.out.println("New Salary : " + newCS);

        System.out.println("----------------");

        // ! 4. Stagiaire which must throw exception
        Stagiaire s = new Stagiaire("Yasmine", "Benali", 30000, 6);
        try {
            s.augmenterSalaire(s.getSalary(), 20); // * Any increase not allowed
        } catch (AugmentationImpossibleException e) {
            System.out.println("Stagiaire Exception: " + e.getMessage());
        }

        System.out.println("----------------");
    }
}
