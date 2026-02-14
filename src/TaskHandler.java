import java.util.LinkedList;
import java.util.List;

public class TaskHandler {

    private List<Task> tasks = new LinkedList<>();

    public void addTask(String description) {

        Task task = new Task(description);
        tasks.add(task);
        task.setId(tasks.indexOf(task));
        System.out.printf("Task added successfully (ID: %d)\n", task.getId());
        task.getTaskInfo();
    }

    public void updateTask(int id, String description) {

        tasks.get(id).setDescription(description);
        tasks.get(id).setUpdatedAt();
        System.out.printf("Updated your task №%d\n", id+1);
        tasks.get(id).getTaskInfo();
    }

}
