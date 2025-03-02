package Ex3;

public class Student {
    private String name;
    private String surname;
    private int idNumber;
    static int num_of_students = 0;
    private double[] modules;

    public Student(String name, String surname, int idNumber) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.modules = new double[]{0, 0, 0}; 
        num_of_students++;
        System.out.println("Total Students: " + num_of_students);
       
    }

    public Student(String name, String surname, int idNumber, double mod1, double mod2, double mod3) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.modules = new double[]{mod1, mod2, mod3};
        num_of_students++;
        System.out.println("Total Students: " + num_of_students);
    }

    public void display() {
        System.out.println("Name: " + name + " | Surname: " + surname + " | ID: " + idNumber);

        if (modules[0] == 0 && modules[1] == 0 && modules[2] == 0) {
            System.out.println("No module records (Student from same institution).");
        } else {
            System.out.println("Modules: " + modules[0] + ", " + modules[1] + ", " + modules[2]);
            System.out.println("Average: " + calculateAverage());
        }
        System.out.println("--------------------------------");
    }
    
    public double calculateAverage() {
        return (modules[0] + modules[1] + modules[2]) / 3;
    }
}
