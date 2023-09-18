package studentenrollment;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public List<Student> listEnrolledStudents() {
        return enrolledStudents;
    }

    public void removeStudent(int studentID) {
        for (Student student : enrolledStudents) {
            if (student.getStudentID() == studentID) {
                enrolledStudents.remove(student);
                break;
            }
        }
    }
}
