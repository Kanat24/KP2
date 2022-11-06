package KP2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AnnualTask extends Task {

    public AnnualTask(String header, String description, boolean typeTask, LocalDateTime localDateTime) {
        super(header, description, typeTask, localDateTime);
    }

    @Override
    public boolean getNextData(LocalDate date) {
        LocalDate taskCreationDate = getTaskDateTime().toLocalDate();
        return taskCreationDate.equals(date)
                || (date.getDayOfMonth() == taskCreationDate.getDayOfMonth()
                && date.getMonthValue() == taskCreationDate.getMonthValue());
    }
}
