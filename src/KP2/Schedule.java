package KP2;

import KP2.Task;
import KP2.TaskTimeComparator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Schedule {
    private static final Map<Integer, Task> map = new HashMap<>();

    public static void addTask(Task task) {
        map.put(task.getId(), task);
    }

    public static void removeTask(int id) {
        if (!map.containsKey(id)) {
            throw new IllegalArgumentException("Некорректный Id");
        }
        map.remove(id);
        System.out.println("Задача под номером " + id + " удалена");
    }

    public static Collection<Task> getTaskforDay(LocalDate localDate) {
        Set<Task> taskForDay = new TreeSet<>(new TaskTimeComparator());
        try {
            for (Task task : map.values()) {
                if (task.getNextData(localDate)) {
                    taskForDay.add(task);
                }
            }
            System.out.println(taskForDay);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка : неправильный ввод");
        }
        return taskForDay;
    }
}
