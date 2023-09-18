package studentenrollment;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        while (true) {
            System.out.println("Mathematica Student Enrollment");
            System.out.println("1. Add Student to Course");
            System.out.println("2. List Enrolled Students");
            System.out.println("3. Remove Student from Course");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student email: ");
                    String studentEmail = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();

                    Course selectedCourse = null;
                    for (Course course : courses) {
                        if (course.getName().equalsIgnoreCase(courseName)) {
                            selectedCourse = course;
                            break;
                        }
                    }

                    if (selectedCourse != null) {
                        Student newStudent = new Student(studentName, studentID, studentEmail);
                        selectedCourse.addStudent(newStudent);
                        System.out.println("Student added to course successfully!");
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter course name to list enrolled students: ");
                    String listCourseName = scanner.nextLine();

                    for (Course course : courses) {
                        if (course.getName().equalsIgnoreCase(listCourseName)) {
                            List<Student> enrolledStudents = course.listEnrolledStudents();
                            System.out.println("Enrolled Students in " + course.getName() + ":");
                            for (int i = 0; i < enrolledStudents.size(); i++) {
                                System.out.println((i + 1) + ". " + enrolledStudents.get(i));
                            }
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter course name: ");
                    String removeCourseName = scanner.nextLine();
                    System.out.print("Enter student ID to remove: ");
                    int removeStudentID = scanner.nextInt();
                    scanner.nextLine();

                    for (Course course : courses) {
                        if (course.getName().equalsIgnoreCase(removeCourseName)) {
                            course.removeStudent(removeStudentID);
                            System.out.println("Student removed from course successfully!");
                            break;
                        }
                    }
                    break;

                case 4:
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
