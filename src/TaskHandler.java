import java.util.ArrayList;
import java.util.List;

public class TaskHandler {

    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public void addTask(String description) {
        Task task = new Task(description);
        task.setId(nextId++);
        tasks.add(task);

        TaskStorage.writeTasksToJson(tasks);
        System.out.printf("Task added successfully (ID: %d)\n", task.getId());
    }

    public void updateTask(int id, String description) {

        Task task = findById(id);

        if(task != null) {
            task.setDescription(description);
            task.setUpdatedAt();

            TaskStorage.writeTasksToJson(tasks);
            System.out.printf("Successfully updated task (ID: %d)\n", id);
        } else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id);
        }
    }

    public void deleteTask(int id) {

        Task task = findById(id);

        if(task != null) {
            tasks.remove(task);

            TaskStorage.writeTasksToJson(tasks);
            System.out.printf("Successfully deleted task (ID: %d)\n", id);
        } else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id);
        }
    }

    public void markInProgress(int id) {

        Task task = findById(id);

        if(task != null) {
            task.setStatus(TaskStatus.IN_PROGRESS);

            TaskStorage.writeTasksToJson(tasks);
            System.out.printf("Successfully marked as in progress task (ID: %d)\n", id);
        }
        else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id);
        }
    }

    public void markDone(int id) {

        Task task = findById(id);

        if(task != null) {
            task.setStatus(TaskStatus.DONE);

            TaskStorage.writeTasksToJson(tasks);
            System.out.printf("Successfully marked done task (ID: %d)\n", id);
        }
        else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id);
        }
    }

    private Task findById(int id) {

        for(Task task : tasks) {
            if(task.getId() == id) return task;
        }

        return null;
    }

}
