import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManagerController {

    private List<Task> tasks;

    public TaskManagerController() {
        this.tasks = new ArrayList<Task>();
    }

    public Integer createTask(String title, String description, String date, String priority) {
        LocalDate dateTask = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Task task = new Task(title, description, dateTask, priority);

        if (!tasks.contains(task)) {
            this.tasks.add(task);
            return this.tasks.indexOf(task);
        } else {
            return -1;
        }
    }

    public String updateTitleTask(int i, String title) throws Exception {
        try {
            Task task = this.tasks.get(i);
            task.setTitle(title);

            return task.getTitle();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updateDescriptionTask(int i, String description) throws Exception {
        try {
            Task task = this.tasks.get(i);
            task.setDescription(description);

            return task.getDescription();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updateDateTask(int i, String date) throws Exception {
        try {
            Task task = this.tasks.get(i);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateTask = LocalDate.parse(date, formatter);

            task.setDate(dateTask);
            return task.getDate().format(formatter);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updatePriorityTask(int i, String priority) throws Exception {
        try {
            Task task = this.tasks.get(i);
            task.setPriority(priority);

            return task.getPriority();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void removeTask(String title, String description, String date, String priority) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateTask = LocalDate.parse(date, formatter);

            Task task = new Task(title, description, dateTask, priority);

            if (this.tasks.contains(task)) {
                this.tasks.remove(task);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public List<Task> getTasks() {
        return this.tasks;
    }
}
