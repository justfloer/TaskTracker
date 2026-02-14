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
        this.updatedAt = createdAt;
    }

    //ID
    public void setId(int id) {
        this.id = id + 1; // +1 to start from 1 not 0 because of LinkedList
    }
    public int getId() {
        return this.id;
    }

    //DESCRIPTION
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //STATUS
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public TaskStatus getStatus() {
        return this.status;
    }

    //CREATED AT
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
    public String getFormattedCreatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return createdAt.format(formatter);
    }

    //UPDATED AT
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
    public String getFormattedUpdatedAt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return updatedAt.format(formatter);
    }

    //GET TASK INFO
    public void getTaskInfo() {
        System.out.printf("ID: %d, Description: " + this.description + "\n", this.id);
        System.out.println("Status: " + this.status);
        System.out.println("Created at " + this.getFormattedCreatedAt());
        System.out.println("Updated at " + this.getFormattedUpdatedAt());
    }
}
