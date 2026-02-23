import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskStorage {

    private static final String FILE_PATH = "src\\tasks.json";

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

    public static List<Task> readTasksFromJson() {

        List<Task> tasks = new ArrayList<>();
        if(!Files.exists(Paths.get(FILE_PATH))) return tasks;

        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

            int id = 0;
            String description = "";
            TaskStatus status = TaskStatus.TODO;
            LocalDateTime createdAt = null, updatedAt = null;

            for(String line : lines) {
                line = line.trim();

                if(line.startsWith("\"id\"")) {
                    id = Integer.parseInt(parseLine(line));
                }
                if(line.startsWith("\"description\"")) {
                    description = parseLine(line);
                }
                if(line.startsWith("\"status\"")) {
                    status = TaskStatus.valueOf(parseLine(line));
                }
                if(line.startsWith("\"createdAt\"")) {
                    createdAt = LocalDateTime.parse(parseLineForDate(line), Task.formatter);
                }
                if(line.startsWith("\"updatedAt\"")) {
                    updatedAt = LocalDateTime.parse(parseLineForDate(line), Task.formatter);
                    Task task = new Task(id, description, status, createdAt, updatedAt);
                    tasks.add(task);
                }
            }

        } catch (IOException e) {
            System.out.println("Could not read file.");
        }

        return tasks;
    }

    private static String parseLine(String str) {
        return str.split(":")[1].replace(",", "").replace("\"", "").trim();
    }

    private static String parseLineForDate(String str) {
        return str.split(":")[1].replace("\"", "").trim()
                + ":"
                + str.split(":")[2].replace(",", "").replace("\"", "");
    }
}
