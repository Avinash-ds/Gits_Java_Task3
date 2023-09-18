package tasklist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskList taskList = new TaskList();

        while (true) {
            System.out.println("Task List");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. List Tasks");
            System.out.println("4. Remove Task");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter due date (YYYY-MM-DD): ");
                    String dueDate = scanner.nextLine();
                    System.out.print("Enter priority (High, Medium, Low): ");
                    String priority = scanner.nextLine();
                    Task newTask = new Task(taskName, dueDate, priority);
                    taskList.addTask(newTask);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.print("Enter the task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    scanner.nextLine();
                    taskList.markTaskAsCompleted(taskNumber);
                    break;

                case 3:
                    List<Task> taskListItems = taskList.listTasks();
                    System.out.println("Task List:");
                    for (int i = 0; i < taskListItems.size(); i++) {
                        System.out.println((i + 1) + ". " + taskListItems.get(i));
                    }
                    break;

                case 4:
                    System.out.print("Enter the task number to remove: ");
                    int removeTaskNumber = scanner.nextInt();
                    scanner.nextLine();
                    taskList.removeTask(removeTaskNumber);
                    break;

                case 5:
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
