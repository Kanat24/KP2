package KP2;

import java.util.Comparator;

public class TaskTimeComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        return task1.getTaskDateTime().toLocalTime().compareTo(task2.getTaskDateTime().toLocalTime());
    }
}
