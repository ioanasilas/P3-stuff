import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// for task lifecycle
public class TaskManager {
    private Task currentTask;
    private TaskCategory[] categories;
    private String filename;

    public TaskManager(Task currentTask, TaskCategory[] categories, String filename) {
        this.currentTask = currentTask;
        this.categories = categories;
        this.filename = filename;
    }

    public boolean addTask(String title, String description, int priority, LocalDate deadline, String categoryName) throws DuplicateTaskException {
        // loop thru categories to find the right one
        for (TaskCategory category : categories) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                if (category.getTaskByName(title) != null) {
                    throw new DuplicateTaskException("Task with title " + title + " already exists");
                }
                Task task = new Task(title, description, priority, deadline);
                category.addTask(task);
                // does absolutely nothing
                this.currentTask = task;
                // save to the file
                saveToFile(task, categoryName);
                return true;
            }
        }
        System.out.println("❌ Category " + categoryName + " does not exist");
        return false;
    }


    public void removeTask(String title) {
        boolean removed = false;
        for (TaskCategory category : categories) {
            Task task = category.getTaskByName(title);
            if (task != null) {
                category.removeTask(task);
                removeFromFile(title);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("✅ Task removed.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    public Task findTask(String title) {
        for (TaskCategory category : categories) {
            for (Task task : category.getTasks()) {
                if (task != null && task.getTitle().equals(title)) {
                    return task;
                }
            }
        }
        return null;
    }

    public TaskCategory findCategory(String categoryName) {
        for (TaskCategory category : categories) {
            if (category != null && category.getCategoryName().equals(categoryName)) {
                return category;
            }
        }
        return null;
    }

    public Task[] getTasks() {
        // count the total number of tasks across all categories
        int totalTaskCount = 0;
        for (TaskCategory category : categories) {
            for (Task task : category.getTasks()) {
                if (task != null) {
                    totalTaskCount++;
                }
            }
        }

        // create an array with the exact size
        Task[] allTasks = new Task[totalTaskCount];
        int index = 0;

        // populate the allTasks array with tasks from each category
        for (TaskCategory category : categories) {
            for (Task task : category.getTasks()) {
                if (task != null) {
                    allTasks[index++] = task;
                }
            }
        }
        return allTasks;
    }

    // Lab 5 files
    public void saveToFile(Task task, String categoryName) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile(); // create the file if it does not exist
                System.out.println("📁 File created: " + filename);
            }

            //  append to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                if (task != null) {
                    String csvLine = task.toCSV() + "," + categoryName + "\n";
                    writer.write(csvLine);
                    System.out.println("✅ Task saved to " + filename);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving tasks: " + e.getMessage());
        }
    }

    public List<Task> loadTasksFromFile() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) { // Skip empty lines
                    try {
                        String[] parts = line.split(",");

                        String title = parts[0];
                        String description = parts[1];
                        int priority = Integer.parseInt(parts[2]);
                        LocalDate deadline = LocalDate.parse(parts[3]);
                        String categoryName = parts[4];

                        Task task = new Task(title, description, priority, deadline);
                        tasks.add(task);
                    } catch (Exception e) {
                        System.out.println("⚠️ Error parsing line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading tasks from file: " + e.getMessage());
        }
        return tasks;
    }


    public void removeFromFile(String title)
    {
        List<String> updatedLines = new ArrayList<>();
        // read tasks from file and filter out the one to be removed
        try(BufferedReader reader = new BufferedReader(new FileReader(filename)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(",");
                if (!parts[0].equals(title)) {
                    updatedLines.add(line);
                }
            }

        }
        catch (IOException e)
        {
            System.out.println("❌ Error reading from file: " + e.getMessage());;
        }

        // write other tasks back, overwrite
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false)))
        {
            for (String line : updatedLines)
            {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("✅ Task removed from file.");
        }
        catch (IOException e)
        {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }
}
