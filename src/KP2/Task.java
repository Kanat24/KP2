package KP2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Task {
    protected final String header;
    protected final String description;
    protected final boolean typeTask;
    protected LocalDateTime nextTask;
    protected LocalDateTime created;
    private static int counter = 1;
    public final int id;
    private final LocalDateTime taskDateTime;

    public LocalDateTime getTaskDateTime() {
        return taskDateTime;
    }


    public int getId() {
        return id;
    }

    public Task(String header, String description, boolean typeTask, LocalDateTime taskDateTime) {
        this.header = header;
        this.description = description;
        this.typeTask = typeTask;
        this.taskDateTime = taskDateTime;
        this.id = counter++;
        this.created = LocalDateTime.now();
        this.nextTask = taskDateTime;
        ValidationUtils.Validation(header);
        ValidationUtils.Validation(description);
    }

    public abstract boolean getNextData(LocalDate date);

    public boolean isTypeTask() {
        return typeTask;
    }

    public LocalDateTime getNextTask() {
        return nextTask;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public boolean getTypeTask() {
        return typeTask;
    }


    @Override
    public String toString() {
        return "Задача номер" + id + '\'' +
                "Название задачи='" + header + '\'' +
                ", Описание задачи='" + description + '\'' +
                ", это рабочая задача?'" + typeTask +
                ", Дата и время задачи=" + taskDateTime.format(Diary.dtf);
    }

}

