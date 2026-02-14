import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        TaskHandler taskHandler = new TaskHandler();

        while (isRunning) {

            System.out.println("What would you like to do?");
            System.out.println("-> add (Add a task)");
            System.out.println("-> update (Update a task)");
            System.out.println("-> delete (Delete a task)");
            System.out.println("-> quit (Quit the program)");
            String decision = sc.next().toUpperCase();
            sc.nextLine();
            CommandOptions commandOptions = CommandOptions.valueOf(decision);

            switch (commandOptions) {
                case ADD -> {
                    System.out.print("What task would you like to add? -> ");
                    String description = sc.nextLine();
                    taskHandler.addTask(description);
                }
                case UPDATE -> {
                    System.out.println("Which task and how would you like to update?");
                    int id = sc.nextInt() - 1;
                    //проверить есть ли задание с таким номером!!!!
                    sc.nextLine();
                    String newDescription = sc.nextLine();
                    taskHandler.updateTask(id, newDescription);

                }
                case QUIT -> isRunning = false;
                default -> System.out.println("You must select from the options provided!");
            }
        }

        sc.close();

    }

}
