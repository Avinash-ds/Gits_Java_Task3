package gradetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeBook gradeBook = new GradeBook();

        while (true) {
            System.out.println("Grade Book");
            System.out.println("1. Add Student");
            System.out.println("2. Calculate Average for a Student");
            System.out.println("3. Calculate Class Average");
            System.out.println("4. Display Student List (sorted by average)");
            System.out.println("5. Search for Student");
            System.out.println("6. Remove Student");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student grades (comma-separated): ");
                    String gradesInput = scanner.nextLine();
                    String[] gradeTokens = gradesInput.split(",");
                    ArrayList<Integer> grades = new ArrayList<>();
                    for (String token : gradeTokens) {
                        grades.add(Integer.parseInt(token.trim()));
                    }
                    gradeBook.addStudent(id, name, grades);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    Student foundStudent = gradeBook.findStudentById(studentId);
                    if (foundStudent != null) {
                        System.out.println("Student: " + foundStudent.getName());
                        System.out.println("Grades: " + foundStudent.getGrades());
                        System.out.println("Average Grade: " + foundStudent.getAverageGrade());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    gradeBook.calculateClassAverage();
                    break;

                case 4:
                    gradeBook.displayStudentList();
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    int searchId = scanner.nextInt();
                    Student searchResult = gradeBook.findStudentById(searchId);
                    if (searchResult != null) {
                        System.out.println("Student: " + searchResult.getName());
                        System.out.println("ID: " + searchResult.getId());
                        System.out.println("Grades: " + searchResult.getGrades());
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    gradeBook.removeStudentById(removeId);
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}