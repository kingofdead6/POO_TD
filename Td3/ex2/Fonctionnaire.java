package ex2;

public class Fonctionnaire implements AugmentationSalaire {
    protected String name;
    protected String firstName;
    protected double salary;

    public Fonctionnaire(String name, String firstName, double salary) {
        this.name = name;
        this.firstName = firstName;
        this.salary = salary;
    }

    @Override
    public double augmenterSalaire(double salaire, double pourcentage) throws AugmentationImpossibleException {
        double newSalary = salaire + (salaire * pourcentage / 100);
        if (newSalary > 200000) {
            throw new AugmentationImpossibleException("New salary exceeds 200000 DA");
        }
        this.salary = newSalary;
        return this.salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fonctionnaire other = (Fonctionnaire) obj;
        return this.name.equals(other.name) && this.firstName.equals(other.firstName);
    }

    public double getSalary() {
        return this.salary;
    }
}
