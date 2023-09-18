package gradetracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class GradeBook {
    private ArrayList<Student> roster = new ArrayList<>();

    // Method to add a student to the roster with ID, name, and grades
    public void addStudent(int id, String name, ArrayList<Integer> grades) {
        Student student = new Student(id, name);
        student.getGrades().addAll(grades);
        roster.add(student);
    }

    // Method to calculate and display the average grade for the entire class
    public void calculateClassAverage() {
        double sum = 0;
        int count = 0;

        for (Student student : roster) {
            sum += student.getAverageGrade();
            count++;
        }

        double classAverage = sum / count;
        System.out.println("Class Average: " + classAverage);
    }

    // Method to display the student list sorted by average grade in descending
    // order
    public void displayStudentList() {
        Collections.sort(roster, Comparator.comparingDouble(Student::getAverageGrade).reversed());

        System.out.println("Student List (sorted by average):");
        int position = 1;
        for (Student student : roster) {
            System.out.println(position + ". " + student.getName() + " (ID: " + student.getId() + ") - Average Grade: "
                    + student.getAverageGrade());
            position++;
        }
    }

    // Method to find a student by ID and return the Student object
    public Student findStudentById(int id) {
        for (Student student : roster) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // Return null if student is not found
    }

    // Method to remove a student from the roster by ID
    public void removeStudentById(int id) {
        Student studentToRemove = null;
        for (Student student : roster) {
            if (student.getId() == id) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            roster.remove(studentToRemove); // Remove the student
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}