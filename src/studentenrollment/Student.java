package studentenrollment;

public class Student {
    private String name;
    private int studentID;
    private String email;

    public Student(String name, int studentID, String email) {
        this.name = name;
        this.studentID = studentID;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return name + " (ID: " + studentID + ", Email: " + email + ")";
    }
}
