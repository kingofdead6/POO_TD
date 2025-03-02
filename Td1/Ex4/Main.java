import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Main {
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color FOREGROUND_COLOR = Color.RED;
    private static final Dimension FRAME_SIZE = new Dimension(1500, 800);

    private JFrame frame;
    private JTextArea displayArea;
    private AttendanceService service;
    private Training training;

    public Main() {
        service = new AttendanceService();
        setupData();
        initializeFrame();
        initializeDisplayArea();
        initializeButtons();
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Attendance System");
        frame.setSize(FRAME_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    private void initializeDisplayArea() {
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setBackground(BACKGROUND_COLOR);
        displayArea.setForeground(FOREGROUND_COLOR);
        displayArea.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(new JScrollPane(displayArea), BorderLayout.CENTER);
        
    }

    private void initializeButtons() {
        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND_COLOR);

        JButton btnShowStudents = createButton("Show Students", e -> displayArea.setText(service.displayEnrolledStudents()));
        JButton btnShowWorkshops = createButton("Show Workshops", e -> displayArea.setText(service.displayWorkshops(training)));
        JButton btnShowAbsentees = createButton("Show Absentees", e -> showAbsentees());
        JButton btnAddStudent = createButton("Add Student", e -> addStudentDialog());
        JButton btnCreateWorkshop = createButton("Create Workshop", e -> createWorkshopDialog());
        JButton btnEnterWorkshop = createButton("Enter Workshop", e -> enterWorkshopDialog());
        JButton btnAddStudentToWorkshop = createButton("Add Student to Workshop", e -> addStudentToWorkshopDialog());
        JButton btnMarkAbsence = createButton("Mark Absence", e -> markAbsenceDialog());

        panel.add(btnShowStudents);
        panel.add(btnShowWorkshops);
        panel.add(btnShowAbsentees);
        panel.add(btnAddStudent);
        panel.add(btnCreateWorkshop);
        panel.add(btnEnterWorkshop);
        panel.add(btnAddStudentToWorkshop);
        panel.add(btnMarkAbsence);

        frame.add(panel, BorderLayout.SOUTH);
    }



   private JButton createButton(String text, ActionListener action) {
       JButton button = new JButton(text);
       
       button.setFont(new Font("SansSerif", Font.BOLD, 14));
       button.setMargin(new Insets(10, 20, 10, 20));
   
       Color normalColor = Color.decode("#323232"); 
       Color hoverColor = Color.decode("#730b00");
       
       Color textColor = Color.WHITE;
   
       button.setBackground(normalColor);
       button.setForeground(textColor);
       button.setBorderPainted(false);
       button.setFocusPainted(false);
       
       button.setContentAreaFilled(false);
       button.setOpaque(false);
   
       button.addMouseListener(new java.awt.event.MouseAdapter() {
           @Override
           public void mouseEntered(java.awt.event.MouseEvent evt) {
               button.setBackground(hoverColor);
           }
   
           @Override
           public void mouseExited(java.awt.event.MouseEvent evt) {
               button.setBackground(normalColor);
           }
       });
   
       button.addActionListener(action);
   
       button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
           @Override
           protected void paintButtonPressed(Graphics g, AbstractButton b) {
               Graphics2D g2 = (Graphics2D) g;
               g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
               g2.setColor(button.getBackground());
               g2.fill(new RoundRectangle2D.Float(0, 0, b.getWidth(), b.getHeight(), 15, 15));
               super.paintButtonPressed(g, b);
           }
       });
   
       return button;
   }


    private void showAbsentees() {
        List<Workshop> workshops = training.getWorkshops();
        if (!workshops.isEmpty()) {
            displayArea.setText(service.displayAbsentees(workshops.get(0)));
        } else {
            displayArea.setText("No workshops available.");
        }
    }

    private void setupData() {
        training = new Training("Or11", "Oracle");
        service.addTraining(training);

        Student s1 = new Student("Ali", "Ahmed", "S001");
        Student s2 = new Student("Sara", "Belaid", "S002");
        Student s3 = new Student("Omar", "Kacem", "S003");
        training.addStudent(s1);
        training.addStudent(s2);
        training.addStudent(s3);

        Workshop w1 = new Workshop("16/02/2025", "14:30", training);
        Workshop w2 = new Workshop("17/02/2025", "10:00", training);
        training.addWorkshop(w1);
        training.addWorkshop(w2);

        service.recordAbsences(w1, new Student[]{s1, s2});
        service.recordAbsences(w2, new Student[]{s3});
    }

    private void addStudentDialog() {
        JTextField firstNameField = new JTextField(10);
        JTextField lastNameField = new JTextField(10);
        JTextField idField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("ID:"));
        panel.add(idField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Student", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String id = idField.getText();

            Student newStudent = new Student(firstName, lastName, id);
            training.addStudent(newStudent);
            displayArea.setText("Student added: " + firstName + " " + lastName);
        }
    }

    private void createWorkshopDialog() {
        JTextField dateField = new JTextField(10);
        JTextField timeField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Date (DD/MM/YYYY):"));
        panel.add(dateField);
        panel.add(new JLabel("Time (HH:MM):"));
        panel.add(timeField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Create Workshop", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String date = dateField.getText();
            String time = timeField.getText();

            Workshop newWorkshop = new Workshop(date, time, training);
            training.addWorkshop(newWorkshop);
            displayArea.setText("Workshop added on: " + date + " at " + time);
        }
    }

    private void enterWorkshopDialog() {
        List<Workshop> workshops = training.getWorkshops();
        if (workshops.isEmpty()) {
            displayArea.setText("No workshops available to enter.");
            return;
        }

        String[] workshopOptions = workshops.stream().map(Workshop::getDate).toArray(String[]::new);
        JComboBox<String> workshopDropdown = new JComboBox<>(workshopOptions);
        JPanel panel = new JPanel();
        panel.setBackground(BACKGROUND_COLOR);
        panel.add(new JLabel("Select a workshop:"));
        panel.add(workshopDropdown);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Enter Workshop", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedIndex = workshopDropdown.getSelectedIndex();
            Workshop selectedWorkshop = workshops.get(selectedIndex);
            String absentees = service.displayAbsentees(selectedWorkshop);
            String presentStudents = service.displayPresentStudents(selectedWorkshop);

            displayArea.setText("Workshop: " + selectedWorkshop.getDate() + "\n" +
                    "Present Students:\n" + presentStudents +
                    "\nAbsent Students:\n" + absentees);
        }
    }

    private void addStudentToWorkshopDialog() {
        List<Workshop> workshops = training.getWorkshops();
        List<Student> students = training.getStudents();

        if (workshops.isEmpty() || students.isEmpty()) {
            displayArea.setText("No workshops or students available.");
            return;
        }

        String[] workshopOptions = workshops.stream().map(Workshop::getDate).toArray(String[]::new);
        String[] studentOptions = students.stream().map(Student::getFullName).toArray(String[]::new);

        JComboBox<String> workshopDropdown = new JComboBox<>(workshopOptions);
        JComboBox<String> studentDropdown = new JComboBox<>(studentOptions);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Workshop:"));
        panel.add(workshopDropdown);
        panel.add(new JLabel("Select Student:"));
        panel.add(studentDropdown);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Student to Workshop", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedWorkshopIndex = workshopDropdown.getSelectedIndex();
            int selectedStudentIndex = studentDropdown.getSelectedIndex();

            Workshop selectedWorkshop = workshops.get(selectedWorkshopIndex);
            Student selectedStudent = students.get(selectedStudentIndex);

            selectedWorkshop.addStudent(selectedStudent);
            displayArea.setText("Student " + selectedStudent.getFullName() + " added to workshop on " + selectedWorkshop.getDate());
        }
    }

    private void markAbsenceDialog() {
        List<Workshop> workshops = training.getWorkshops();
        if (workshops.isEmpty()) {
            displayArea.setText("No workshops available.");
            return;
        }

        String[] workshopOptions = workshops.stream().map(Workshop::getDate).toArray(String[]::new);
        JComboBox<String> workshopDropdown = new JComboBox<>(workshopOptions);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Workshop:"));
        panel.add(workshopDropdown);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Select Workshop", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int selectedWorkshopIndex = workshopDropdown.getSelectedIndex();
            Workshop selectedWorkshop = workshops.get(selectedWorkshopIndex);

            List<Student> studentsInWorkshop = selectedWorkshop.getStudents();
            if (studentsInWorkshop.isEmpty()) {
                displayArea.setText("No students in this workshop.");
                return;
            }

            String[] studentOptions = studentsInWorkshop.stream().map(Student::getFullName).toArray(String[]::new);
            JList<String> studentList = new JList<>(studentOptions);
            studentList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

            JScrollPane scrollPane = new JScrollPane(studentList);
            JPanel absencePanel = new JPanel();
            absencePanel.add(new JLabel("Select Absent Students:"));
            absencePanel.add(scrollPane);

            int absenceResult = JOptionPane.showConfirmDialog(frame, absencePanel, "Mark Absences", JOptionPane.OK_CANCEL_OPTION);
            if (absenceResult == JOptionPane.OK_OPTION) {
                List<String> selectedAbsentees = studentList.getSelectedValuesList();
                List<Student> absentStudents = studentsInWorkshop.stream()
                        .filter(student -> selectedAbsentees.contains(student.getFullName()))
                        .toList();

                service.recordAbsences(selectedWorkshop, absentStudents.toArray(new Student[0]));
                displayArea.setText("Absences recorded for workshop on " + selectedWorkshop.getDate());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
