package ex2;

public class ChefService extends Fonctionnaire {
    String service; 

    public ChefService(String name, String firstName, double salary, String service) {
        super(name, firstName, salary);
        this.service = service;
    }
    public double augmenterSalaire() {
        double newSalary = this.salary + (this.salary * 0.15); //* Augments by 15%
        this.salary = newSalary;
        return newSalary;
    }
}
