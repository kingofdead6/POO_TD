package Ex3;

import java.util.Scanner;

public class Administration {
    private static Student[] students = new Student[500];
    private static int studentCount = 0;

    public static void addStudent(String name, String surname, int idNumber) {
        if (studentCount < 500) {
            students[studentCount++] = new Student(name, surname, idNumber);
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Error: Maximum student limit reached.");
        }
    }

    public static void addStudent(String name, String surname, int idNumber, double[] modules) {
        if (studentCount < 500) {
            students[studentCount++] = new Student(name, surname, idNumber, modules[0], modules[1], modules[2]);
            System.out.println("Transferred student added successfully!");
        } else {
            System.out.println("Error: Maximum student limit reached.");
        }
    }

    public static void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
        } else {
            System.out.println("List of all students:");
            for (int i = 0; i < studentCount; i++) {
                students[i].display();
            }
        }
    }

    public static void displayStudentsAboveThreshold(double threshold) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].calculateAverage() > threshold) {
                students[i].display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students found with an average above " + threshold);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add new student or transferred student");
            System.out.println("2. Display all students");
            System.out.println("3. Display students above a certain average threshold");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Is the student transferred from another institution? (yes/no)");
                    String response = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter surname: ");
                    String surname = scanner.nextLine();
                    System.out.print("Enter ID number: ");
                    int idNumber = scanner.nextInt();

                    if (response.equals("yes")) {
                        System.out.print("Enter module 1 average: ");
                        double mod1 = scanner.nextDouble();
                        System.out.print("Enter module 2 average: ");
                        double mod2 = scanner.nextDouble();
                        System.out.print("Enter module 3 average: ");
                        double mod3 = scanner.nextDouble();
                        double[] modules = {mod1, mod2, mod3};
                        addStudent(name, surname, idNumber, modules);
                    } else {
                        addStudent(name, surname, idNumber);
                    }
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    System.out.print("Enter the average threshold: ");
                    double threshold = scanner.nextDouble();
                    displayStudentsAboveThreshold(threshold);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
