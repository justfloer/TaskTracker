import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //To-Do: обработать краевые ситуации при приеме ввода команды(что id - int и тд тп)
        TaskHandler taskHandler = new TaskHandler();
        String emptyErrorMessage = "Empty command, type <help> for the list of commands";

        if(args.length < 1) {
            System.out.println(emptyErrorMessage);
            return;
        }

        try {
            String command = args[0].toLowerCase();
            CommandOptions commandOptions = CommandOptions.getOptionFromString(command);

            switch (commandOptions) {
                case ADD -> {
                    String description = args[1];
                    taskHandler.addTask(description);
                }
                case UPDATE -> {
                    int id = Integer.parseInt(args[1]);
                    String newDescription = args[2];
                    taskHandler.updateTask(id, newDescription);

                }
                case DELETE -> {
                    int id = Integer.parseInt(args[1]);
                    taskHandler.deleteTask(id);
                }
                case MARK_IN_PROGRESS -> {
                    int id = Integer.parseInt(args[1]);
                    taskHandler.markInProgress(id);
                }
                case MARK_DONE -> {
                    int id = Integer.parseInt(args[1]);
                    taskHandler.markDone(id);
                }
                case LIST -> {
                    if(args.length == 1) taskHandler.listAll();
                    else{
                        String listOption = args[1].toLowerCase();

                        switch (listOption) {
                            case "done" -> taskHandler.listByStatus(TaskStatus.DONE);
                            case "todo" -> taskHandler.listByStatus(TaskStatus.TODO);
                            case "in-progress" -> taskHandler.listByStatus(TaskStatus.IN_PROGRESS);
                        }
                    }
                }
                case HELP -> {
                    System.out.println("add <\"description\">");
                    System.out.println("update <id> <\"new description\">");
                    System.out.println("delete <id>");
                    System.out.println("mark-in-progress <id>");
                    System.out.println("mark-done <id>");
                    System.out.println("list");
                    System.out.println("list done");
                    System.out.println("list todo");
                    System.out.println("list in-progress");
                    System.out.println("help");
                }
                case null -> System.out.println(emptyErrorMessage);
                default -> System.out.printf("Unknown command: %s, type <help> for the list of commands\n", command);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown command, type <help> for the list of commands");
        }

    }
}
