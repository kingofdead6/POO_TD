import java.util.ArrayList;
import java.util.List;

public class Workshop {
    private String date;
    private String time;
    private boolean conducted;
    private List<Student> absentees;
    private List<Student> enrolledStudents; 
    private Training training;  

    public Workshop(String date, String time, Training training) {
        this.date = date;
        this.time = time;
        this.conducted = false;
        this.absentees = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.training = training;  
    }

    public void markAsConducted(List<Student> absentees) {
        this.conducted = true;
        this.absentees.addAll(absentees);
        for (Student student : absentees) {
            student.addAbsence(this);
        }
    }

    public boolean isConducted() {
        return conducted;
    }

    public String getDetails() {
        return "Workshop on " + date + " at " + time;
    }

    public List<Student> getAbsentees() {
        return absentees;
    }

    public String getDate() {
        return date;
    }

    public Training getTraining() {
        return training;
    }
    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }
    public List<Student> getStudents() {
        return enrolledStudents;
    }
}