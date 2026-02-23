import java.util.List;

public class TaskHandler {

    private final List<Task> tasks = TaskStorage.readTasksFromJson();
    private static int nextId = 1;

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
            task.setUpdatedAt();

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
            task.setUpdatedAt();

            TaskStorage.writeTasksToJson(tasks);
            System.out.printf("Successfully marked done task (ID: %d)\n", id);
        }
        else {
            System.out.printf("Task with (ID: %d) does not exist!\n", id);
        }
    }

    public void listAll() {
        for(Task task : tasks) {
            task.printShortTaskInfo();
        }
    }

    public void listDone() {
        for(Task task : tasks) {
            if(task.getStatus() == TaskStatus.DONE) {
                task.printShortTaskInfo();
            }
        }
    }

    public void listTodo() {
        for(Task task : tasks) {
            if(task.getStatus() == TaskStatus.TODO) {
                task.printShortTaskInfo();
            }
        }
    }

    public void listInProgress() {
        for(Task task : tasks) {
            if(task.getStatus() == TaskStatus.IN_PROGRESS) {
                task.printShortTaskInfo();
            }
        }
    }

    public static void setNextId(int id) {
        nextId = id;
    }

    private Task findById(int id) {

        for(Task task : tasks) {
            if(task.getId() == id) return task;
        }

        return null;
    }

}
