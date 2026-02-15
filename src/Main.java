import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        TaskHandler taskHandler = new TaskHandler();

        while (isRunning) {

            //To-Do: реализовать корректный парсинг команды из терминала
            //To-Do: реализовать хранение данных в JSON
            System.out.println("\nWhat would you like to do?");
            System.out.println("-> add (Add a task)");
            System.out.println("-> update (Update a task)");
            System.out.println("-> delete (Delete a task)");
            System.out.println("-> quit (Quit the program)");

            try {
                String decision = sc.next().toUpperCase();
                sc.nextLine();
                CommandOptions commandOptions = CommandOptions.valueOf(decision);


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
                        int id = sc.nextInt() - 1;
                        sc.nextLine();
                        String newDescription = sc.nextLine();
                        taskHandler.updateTask(id, newDescription);

                    }
                    case DELETE -> {
                        System.out.print("Which task would you like to delete? -> ");
                        int id = sc.nextInt() - 1;
                        sc.nextLine();
                        taskHandler.deleteTask(id);
                    }
                    case QUIT -> isRunning = false;
                    default -> System.out.print("Please, select from the options provided -> ");
                }
            } catch(IllegalArgumentException e) {
                System.out.print("Please, select from the options provided!");
            }
        }

        sc.close();

    }

}
