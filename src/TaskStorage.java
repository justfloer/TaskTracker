import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TaskStorage {

    private static final String FILE_PATH = "src/tasks.json";

    //To-do: implement reading from JSON file

    public static void writeTasksToJson(List<Task> tasks) {

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("[\n");

            for (int i = 0; i < tasks.size(); i++) {
                sb.append(tasks.get(i).taskToJson());
                if(i < tasks.size() - 1) sb.append(",");
                sb.append("\n");
            }

            sb.append("]");

            Files.write(Paths.get(FILE_PATH), sb.toString().getBytes());

        } catch (IOException e) {
            System.out.println("Could not write file.");
        }
    }

}
