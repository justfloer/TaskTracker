import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;
    private String description;
    private TaskStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(String description){
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();

    }

    public void setId(int id) {
        this.id = id + 1; // +1 to start from 1 not 0 because of LinkedList
    }

    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return createdAt.format(formatter);
    }

}
