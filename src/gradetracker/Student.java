package gradetracker;

import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private ArrayList<Integer> grades = new ArrayList<>();

    // Constructor to initialize Student object with ID and name
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter method for ID
    public int getId() {
        return id;
    }

    // Getter method for name
    public String getName() {
        return name;
    }

    // Method to add a grade to the student's grades list
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Method to calculate and return the average grade for the student
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0; // Handle division by zero if no grades are available
        }

        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size(); // Calculate the average
    }

    // Getter method for the grades list
    public ArrayList<Integer> getGrades() {
        return grades;
    }
}