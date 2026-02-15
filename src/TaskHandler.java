import java.util.ArrayList;
import java.util.List;

public class TaskHandler {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {

        Task task = new Task(description);
        tasks.add(task);
        task.setId(tasks.indexOf(task));
        System.out.printf("Task added successfully (ID: %d)\n", task.getId());
        task.getTaskInfo();
    }

    public void updateTask(int id, String description) {
        if(id >= 0 && id < tasks.size()) {
            tasks.get(id).setDescription(description);
            tasks.get(id).setUpdatedAt();
            System.out.printf("Updated task №%d\n", id+1);
            tasks.get(id).getTaskInfo();
        } else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id+1);
        }
    }

    public void deleteTask(int id) {

        //To-do: when deleting need to update ids of tasks going after the deleted one!!!
        if(id >= 0 && id < tasks.size()) {
            tasks.remove(tasks.get(id));
            System.out.printf("Deleted task №%d\n", id+1);
            tasks.get(id).getTaskInfo();
        } else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id+1);
        }
    }

}
