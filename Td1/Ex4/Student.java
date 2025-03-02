import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstname ;
    private String lastname ;
    private String id ;
    private int absenceCount ;
    private List <Workshop> absentWorkshops ;


    public Student(String firstname , String lastname, String id){
        this.firstname = firstname ;
        this.lastname = lastname ;
        this.id = id ;
        this.absenceCount = 0;
        this.absentWorkshops = new ArrayList<>();
    }
      public void addAbsence(Workshop workshop) {
        absenceCount++;
        absentWorkshops.add(workshop);
    }

    public String getName() {
        return firstname + " " + lastname;
    }
    
    public int getAbsenceCount() {
        return absenceCount;
    }

    
    public List<Workshop> getAbsentWorkshops() {
        return absentWorkshops;
    }
    public String getId() {
        return id;
    }
    public String getFirstName(){
        return firstname ;
    }
    public String getLastName(){
        return lastname ;
    }
    public String getFullName(){
        return firstname + " " + lastname ;
    }
}

