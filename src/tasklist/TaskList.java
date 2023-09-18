package tasklist;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTaskAsCompleted(int taskNumber) {
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task task = tasks.get(taskNumber - 1);
            task.markAsCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number");
        }
    }

    public List<Task> listTasks() {
        return tasks;
    }

    public void removeTask(int taskNumber) {
        if (taskNumber >= 1 && taskNumber <= tasks.size()) {
            Task removedTask = tasks.remove(taskNumber - 1);
            System.out.println("Task removed: " + removedTask.getTaskName());
        } else {
            System.out.println("Invalid task number.");
        }
    }

}
