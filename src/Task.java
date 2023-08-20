import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Task implements Comparable<Task>, Serializable {

    private static final long serialVersionUID = 8493702775882752428L;
    private String title;
    private String description;
    private LocalDate date;
    private String priority;

    public Task(String title, String description, LocalDate date, String priority) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(title, task.title) && Objects.equals(description, task.description) && Objects.equals(date, task.date) && Objects.equals(priority, task.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, date, priority);
    }

    @Override
    public int compareTo(Task o) {
        return 0;
    }
}
