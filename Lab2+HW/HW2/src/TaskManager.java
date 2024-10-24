import java.time.LocalDate;

public class TaskManager
{
    private Task currentTask;
    private TaskCategory[] categories;

    public TaskManager(Task currentTask, TaskCategory[] categories)
    {
        this.currentTask = currentTask;
        this.categories = categories;
    }

    public void addTask(String title, String description, int priority, LocalDate deadline, String categoryName)
    {
        // loop thru categories to find the right one
        for (TaskCategory category : categories)
        {
            if (category.getCategoryName().equals(categoryName))
            {
                Task task = new Task(title, description, priority, deadline);
                category.addTask(task);
                System.out.println("Task " + task + " added to " + categoryName);
                System.out.println();
                return;
            }
        }
        System.out.println("Category " + categoryName + " does not exist");
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
}
