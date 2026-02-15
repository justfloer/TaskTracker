import java.util.ArrayList;
import java.util.List;

public class TaskHandler {

    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        task.setId(tasks.indexOf(task));
        TaskStorage.writeTasksToJson(tasks);
        System.out.printf("Task added successfully (ID: %d)\n", task.getId());
    }

    public void updateTask(int id, String description) {
        if(id >= 0 && id < tasks.size()) {
            tasks.get(id).setDescription(description);
            tasks.get(id).setUpdatedAt();
            TaskStorage.writeTasksToJson(tasks);
            System.out.printf("Successfully updated task (ID: %d)\n", id + 1);
        } else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id + 1);
        }
    }

    public void deleteTask(int id) {

        //To-do: when deleting need to update id's of tasks going after the deleted one!!!
        if(id >= 0 && id < tasks.size()) {
            tasks.remove(tasks.get(id));
            TaskStorage.writeTasksToJson(tasks);
            System.out.printf("Successfully deleted task (ID: %d)\n", id + 1);
        } else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id + 1);
        }
    }

}
