package KP2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task {
    public OneTimeTask(String header, String description, boolean typeTask, LocalDateTime localDateTime) {
        super(header, description, typeTask, localDateTime);
    }

    @Override
    public boolean getNextData(LocalDate date) {
        return getTaskDateTime().toLocalDate().equals(date);
    }


}

