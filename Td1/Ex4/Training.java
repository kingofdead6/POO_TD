import java.util.ArrayList;
import java.util.List;

public class Training {
    private String code;
    private String name;

    private List<Student> students;
    private List<Workshop> workshops;

    public Training(String code, String name) {
        this.code = code;
        this.name = name;
        this.students = new ArrayList<>();
        this.workshops = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        if (students.size() < 30) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean addWorkshop(Workshop workshop) {
        if (workshops.size() < 10) {
            workshops.add(workshop);
            return true;
        }
        return false;
    }
    
    public String gerDetails(){
        return code + " - " + name;
    }

    public List<Student> getStudents() {
        return students;
    }
    
    public List<Workshop> getWorkshops() {
        return workshops;
    }
}
