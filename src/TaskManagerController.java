import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManagerController {
    public Integer createTask(String title, String description, Date dateTask, String priority) {
        return 0;
    }

    public String updateTitleTask(int i, String title) {
        return "";
    }

    public String updateDescriptionTask(int i, String description) {
        return "";
    }

    public Date updateDateTask(int i, Date dateTask) {
        return dateTask;
    }

    public String updatePriorityTask(int i, String priority) {
        return "";
    }

    public void removeTask(String title, String description, Date dateTask, String priority) {
    }

    public List<Task> getTasks() {
        ArrayList<Task> tasks = new ArrayList<>();

        return tasks;
    }
}
