import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        // tasks
        Task myTask2 = new Task("Programming 3", "Do Java HW (Meta)", 2, LocalDate.of(2024, 10, 25));
        Task myTask3 = new Task("Operating Systems", "Cry a river", 1, LocalDate.of(2024, 10, 26));
        Task myTask4 = new Task("Operating Systems", "Stop crying, finish dir traversal program", 2, LocalDate.of(2024, 10, 27));
        Task myTask5 = new Task("Combinatorics", "Do Lecture 4 HW", 2, LocalDate.of(2024, 10, 29));
        Task myTask6 = new Task("Combinatorics", "Forget what a permutation is", 3, LocalDate.of(2024, 10, 28));
        Task myTask7 = new Task("Go Gym", "Stop rotting in bed", 2, LocalDate.of(2024, 10, 24));

        // tasks array
        Task[] tasks = new Task[] {myTask4, myTask2, myTask3};

        // task categories
        TaskCategory taskCategory1 = new TaskCategory("Uni Stuff", 10);
        TaskCategory taskCategory2 = new TaskCategory("Health", 10);
        TaskCategory taskCategory3 = new TaskCategory("Nothingness", 10);

        // taskcategory array
        TaskCategory[] taskCategories = new TaskCategory[] {taskCategory1, taskCategory2, taskCategory3};

        // task manager
        TaskManager taskManager = new TaskManager(myTask2, taskCategories);

        // adding tasks manually to see both add and remove work in the same run
        taskManager.addTask("Programming 3", "Do Java HW (Meta)", 2, LocalDate.of(2024, 10, 25), "Uni Stuff");
        taskManager.addTask("Go Gym", "Stop rotting in bed", 2, LocalDate.of(2024, 10, 24), "Health");

        // do cmd thingy
        if (args.length > 0)
        {
            String command = args[0];
            switch(command)
            {
                case "addTask":
                {
                    if(args.length == 6)
                    {
                        String taskTitle = args[1];
                        String taskDescription = args[2];
                        int taskPriority = Integer.parseInt(args[3]);
                        LocalDate taskDueDate = LocalDate.parse(args[4]);
                        String taskCategory = args[5];

                        taskManager.addTask(taskTitle, taskDescription, taskPriority, taskDueDate, taskCategory);
                        System.out.println("Task added: " + taskTitle + "\n");
                    }
                    else
                    {
                        System.out.println("Invalid arguments. Usage: addTask <task title> <task description> <task priority> <task due date> <task category>");
                    }
                    break;
                }
                case "removeTask":
                {
                    if (args.length == 2)
                    {
                        String taskTitle = args[1];
                        taskManager.removeTask(taskTitle);
                    }
                    else
                    {
                        System.out.println("Invalid arguments. Usage: removeTask <task title>");
                    }
                    break;
                }
            }
        }
        System.out.println("Existing tasks in taskCategories:");
        for (TaskCategory category : taskCategories)
        {
            for (Task task : category.getTasks())
            {
                if (task != null)
                {
                    System.out.println(task);
                }
            }
        }
    }
}
