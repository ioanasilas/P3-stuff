import java.time.LocalDate;
import java.util.Arrays;

// for task lifecycle
public class TaskManager
{
    private Task currentTask;
    private TaskCategory[] categories;

    public TaskManager(Task currentTask, TaskCategory[] categories)
    {
        this.currentTask = currentTask;
        this.categories = categories;
    }

    public boolean addTask(String title, String description, int priority, LocalDate deadline, String categoryName)
    {
        // loop thru categories to find the right one
        for (TaskCategory category : categories)
        {
            if (category.getCategoryName().equals(categoryName))
            {
                Task task = new Task(title, description, priority, deadline);
                category.addTask(task);
                return true;
            }
        }
        System.out.println("Category " + categoryName + " does not exist");
        return false;
    }


    public void removeTask(String title)
    {
        for (TaskCategory category : categories)
        {
                if (category.removeTask(category.getTaskByName(title)))
                {
                    System.out.println("Task " + title + " removed from category: " + category.getCategoryName());
                }
                else
                {
                    continue;
                }
                return;
        }
        System.out.println("Task not found in any of the existing categories.");
    }

    public Task findTask(String title)
    {
        for (TaskCategory category : categories)
        {
            for (Task task : category.getTasks())
            {
                if (task != null && task.getTitle().equals(title))
                {
                    return task;
                }
            }
        }
        return null;
    }

    public TaskCategory findCategory(String categoryName)
    {
        for (TaskCategory category : categories)
        {
            if (category!= null && category.getCategoryName().equals(categoryName))
            {
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
}
