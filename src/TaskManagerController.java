import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
            String result = "Índice inválido";

            if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                task.setTitle(title);

                result = task.getTitle();
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updateDescriptionTask(int i, String description) throws Exception {
        try {
            String result = "Índice inválido";

            if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                task.setDescription(description);

                result = task.getDescription();
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updateDateTask(int i, String date) throws Exception {
        try {
            String result = "Índice inválido";

            if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dateTask = LocalDate.parse(date, formatter);

                task.setDate(dateTask);
                result = task.getDate().format(formatter);
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String updatePriorityTask(int i, String priority) throws Exception {
        try {
            String result = "Índice inválido";

            if (i >= 0 && i < this.tasks.size()) {
                Task task = this.tasks.get(i);
                task.setPriority(priority);

                result = task.getPriority();
            }

            return result;
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

    public String getSortedTasks() throws Exception {
        try {
            String result = "";

            TaskComparator comparator = new TaskComparator();
            Collections.sort(this.tasks, comparator);

            for (int i = 0; i < this.tasks.size(); i++) {
                result += this.tasks.get(i) + "\n";
            }

            return result;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
