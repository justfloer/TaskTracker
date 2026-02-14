import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new LinkedList<>();

        System.out.print("What task would you like to add? -> ");
        String description = sc.nextLine();
        Task task = new Task(description);
        tasks.add(task);
        task.setId(tasks.indexOf(task));

        System.out.println(task.getId());
        System.out.println(task.getDescription());
        System.out.println(task.getStatus());
        System.out.println(task.getFormattedCreatedAt());

        sc.close();

    }

}
