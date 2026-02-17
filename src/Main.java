import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        TaskHandler taskHandler = new TaskHandler();

        while (isRunning) {

            //To-Do: реализовать корректный парсинг команды из терминала как по заданию
            System.out.println("\nWhat would you like to do?");
            System.out.println("-> add (Add a task)");
            System.out.println("-> update (Update a task)");
            System.out.println("-> delete (Delete a task)");
            System.out.println("-> mark-in-progress (Mark a task as in progress)");
            System.out.println("-> mark-done (Marking a task as done)");
            System.out.println("-> quit (Quit the program)");

            try {
                String decision = sc.next();
                sc.nextLine();
                CommandOptions commandOptions = CommandOptions.getOptionFromString(decision);

                //To-do: для каждого приема данных проверить InputMismatchException
                switch (commandOptions) {
                    case ADD -> {
                        System.out.print("What task would you like to add? -> ");
                        String description = sc.nextLine();
                        taskHandler.addTask(description);
                    }
                    case UPDATE -> {
                        System.out.print("Which task and how would you like to update -> ");
                        //To-Do: реализовать парсинг id и description из одной строки
                        int id = sc.nextInt();
                        sc.nextLine();
                        String newDescription = sc.nextLine();
                        taskHandler.updateTask(id, newDescription);

                    }
                    case DELETE -> {
                        System.out.print("Which task would you like to delete? -> ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        taskHandler.deleteTask(id);
                    }
                    case MARK_IN_PROGRESS -> {
                        System.out.print("Which task would you like to mark as in progress -> ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        taskHandler.markInProgress(id);
                    }
                    case MARK_DONE -> {
                        System.out.print("Which task would you like to mark as done -> ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        taskHandler.markDone(id);
                    }
                    case QUIT -> isRunning = false;
                    case null -> System.out.printf("Unknown command: %s.\n", decision);
                }
            } catch(IllegalArgumentException e) {
                System.out.println("Please, select from the options provided!");
            }
        }

        sc.close();

    }

}
