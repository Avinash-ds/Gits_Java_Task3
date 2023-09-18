package tasklist;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Task {
    private String taskName;
    private Date dueDate;
    private String priority;
    private boolean completed;

    public Task(String taskName, String dueDateStr, String priority) {
        this.taskName = taskName;
        try {
            this.dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.priority = priority;
        this.completed = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dueDate);
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markAsCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "completed" : "Not Completed";
        return "[" + priority + "] " + taskName + " - Due: " + dueDate + " - " + status;
    }

}
