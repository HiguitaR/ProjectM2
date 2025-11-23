package Model;

import java.time.LocalDateTime;

public class HistoryActions {
    private String description;
    private LocalDateTime date;

    public HistoryActions(String description) {
        this.description = description;
        this.date = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }


    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "HistoryActions{" +
                "description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
