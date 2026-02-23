import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;
    private String description;
    private TaskStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Task(String description){
        this.description = description;
        this.status = TaskStatus.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    public Task(int id, String description, TaskStatus status,
                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        TaskHandler.setNextId(id + 1);
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    //ID
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }

    //DESCRIPTION
    public void setDescription(String description) {
        this.description = description;
    }

    //STATUS
    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    public TaskStatus getStatus() {
        return this.status;
    }

    //CREATED AT
    public String getFormattedCreatedAt() {
        return createdAt.format(formatter);
    }

    //UPDATED AT
    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
    public String getFormattedUpdatedAt() {
        return updatedAt.format(formatter);
    }

    //GET TASK INFO
    public String taskToJson() {
        //To-do: make fancier later
        return String.format(
                "\t{\n\t  \"id\": %d,\n\t  \"description\": \"%s\",\n\t  \"status\": \"%s\",\n\t  \"createdAt\": \"%s\",\n\t  \"updatedAt\": \"%s\"\n\t}",
                this.id, this.description, this.status, this.getFormattedCreatedAt(), this.getFormattedUpdatedAt()
        );
    }
    public void printShortTaskInfo() {
        System.out.printf("%s %s(ID: %d)\n",
                this.status.getGraphicalStatus(),
                this.description,
                this.id
        );
    }
}
