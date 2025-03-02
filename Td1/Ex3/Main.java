package Ex3;

public class Main {
    static public void main(String[] args) {
        Student s1 = new Student("John", "Doe", 123456, 50.4, 60.4, 70.4); // !from another intitution
        s1.display() ;
        Student s2 = new Student("Jane", "Doe", 123457); //!from the same intitution
        s2.display();
        Student s3 = new Student("Black", "Guy", 123458); //!from the same intitution
        s3.display();
   
    }
}
