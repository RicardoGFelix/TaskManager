import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task t1, Task t2) {
        String priorityT1 = t1.getPriority();
        String priorityT2 = t2.getPriority();
        if (priorityT1 == priorityT2) {
            return t1.getDate().isBefore(t2.getDate()) ? -1 : 1;
        } else if (priorityT1 == "Alta") {
            return -1;
        }  else if (priorityT2 == "Alta") {
            return 1;
        } else if (priorityT1 == "Média") {
            return -1;
        } else if (priorityT2 == "Média") {
            return 1;
        } else {
            return t1.compareTo(t2);
        }
    }
}
