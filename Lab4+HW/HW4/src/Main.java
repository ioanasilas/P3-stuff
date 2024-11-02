import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // tasks
//        Task myTask2 = new Task("Programming 3", "Do Java HW (Meta)", 2, LocalDate.of(2024, 10, 25));
//        Task myTask3 = new Task("Operating Systems", "Cry a river", 1, LocalDate.of(2024, 10, 26));
//        Task myTask4 = new Task("Operating Systems", "Stop crying, finish dir traversal program", 2, LocalDate.of(2024, 10, 27));
//        Task myTask5 = new Task("Combinatorics", "Do Lecture 4 HW", 2, LocalDate.of(2024, 10, 29));
//        Task myTask6 = new Task("Combinatorics", "Forget what a permutation is", 3, LocalDate.of(2024, 10, 28));
//        Task myTask7 = new Task("Go Gym", "Stop rotting in bed", 2, LocalDate.of(2024, 10, 24));

        // tasks array
        // Task[] tasks = new Task[]{myTask4, myTask2, myTask3};

        // task categories
        TaskCategory taskCategory1 = new TaskCategory("Uni Stuff", 10);
        TaskCategory taskCategory2 = new TaskCategory("Health", 10);
        TaskCategory taskCategory3 = new TaskCategory("Nothingness", 10);

        // taskcategory array
        TaskCategory[] taskCategories = new TaskCategory[]{taskCategory1, taskCategory2, taskCategory3};

        // task manager
        TaskManager taskManager = new TaskManager(null, taskCategories);

        // adding tasks manually to see both add and remove work in the same run
        taskManager.addTask("Programming 3", "Do Java HW (Meta)", 2, LocalDate.of(2024, 10, 25), "Uni Stuff");
        taskManager.addTask("Go Gym", "Stop rotting in bed", 2, LocalDate.of(2024, 10, 24), "Health");
        taskManager.addTask("Combinatorics - Part 1", "Do Lecture 4 HW", 2, LocalDate.of(2024, 10, 29), "Uni Stuff");
        taskManager.addTask("Operating Systems - Part 2", "Stop crying, finish dir traversal program", 2, LocalDate.of(2024, 10, 27), "Uni Stuff");
        taskManager.addTask("Operating Systems - Part 1", "Cry a river", 1, LocalDate.of(2024, 10, 26), "Uni Stuff");
        taskManager.addTask("Combinatorics - Part 2", "Forget what a permutation is", 3, LocalDate.of(2024, 10, 28), "Uni Stuff");


        // get array of all tasks from TaskManager
        Task[] tasks = taskManager.getTasks();

        // menu options if no options provided
        if (args.length == 0) {
            System.out.println("\uD83D\uDD77  Available Commands:");
            System.out.println("1. addTask <task title> <task description> <task priority> <task due date> <task category>");
            System.out.println("2. removeTask <task title>");
            System.out.println("3. filterByPriority <priority>");
            System.out.println("4. filterByDeadline <deadline>");
            System.out.println("5. overallStats");
            System.out.println("6. categoryStats <category name>");
            System.out.println("7. compareTasksByDeadline <task1 title> <task2 title>");
            System.out.println("8. sortTasksByPriority");
            System.out.println("9. compareCategoriesByNoOfTasks <category1 name> <category2 name>");
        }

        // do cmd thingy
        if (args.length > 0) {
            String command = args[0];
            switch (command) {
                case "addTask": {
                    if (args.length == 6) {
                        String taskTitle = args[1];
                        String taskDescription = args[2];
                        int taskPriority = Integer.parseInt(args[3]);
                        LocalDate taskDueDate = LocalDate.parse(args[4]);
                        String taskCategory = args[5];

                        boolean taskAdded = taskManager.addTask(taskTitle, taskDescription, taskPriority, taskDueDate, taskCategory);
                        System.out.println(taskAdded ? "✅ Task added: " + taskTitle + "\n" : "❌ Task not added: " + taskTitle);
                    } else {
                        System.out.println("Invalid arguments. Usage: addTask <task title> <task description> <task priority> <task due date> <task category>");
                    }
                    break;
                }
                case "removeTask": {
                    if (args.length == 2) {
                        String taskTitle = args[1];
                        taskManager.removeTask(taskTitle);
                    } else {
                        System.out.println("Invalid arguments. Usage: removeTask <task title>");
                    }
                    break;
                }
                case "filterByPriority":
                {
                    if (args.length == 2) {
                        try {
                            TaskFilter taskFilter1 = new TaskFilter(tasks);
                            int priority = Integer.parseInt(args[1]);
                            Task[] filteredByPriority = taskFilter1.filterByPriority(priority);

                            if (filteredByPriority.length > 0) {
                                System.out.println("\uD83D\uDCA8 Tasks with priority " + priority + ":");
                                for (Task task : filteredByPriority) {
                                    System.out.println("  - " + task);
                                }
                            } else {
                                System.out.println("🚫 No tasks found with priority: " + priority);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("⚠️ Invalid priority. Please provide a valid integer.");
                        }
                    } else {
                        System.out.println("❌ Invalid arguments. Usage: filterByPriority <priority>");
                    }
                    break;
                }
                case "filterByDeadline":
                {
                    if (args.length == 2) {
                        try {
                            TaskFilter taskFilter1 = new TaskFilter(tasks);
                            LocalDate deadline = LocalDate.parse(args[1]);
                            Task[] filteredByDeadline = taskFilter1.filterByDeadline(deadline);
                            if (filteredByDeadline.length > 0) {
                                System.out.println("\uD83D\uDCC6  Tasks with deadline on or before " + deadline + ":");
                                for (Task task : filteredByDeadline) {
                                    System.out.println("  - " + task);
                                }
                            } else {
                                System.out.println("🚫 No tasks found with deadline on or before: " + deadline);
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("⚠️ Invalid deadline. Please provide a valid format <YYYY-MM-DD>.");
                        }
                    } else {
                        System.out.println("❌ Invalid arguments. Usage: filterByDeadline <deadline>");
                    }
                    break;
                }
                case "overallStats": {
                    TaskStats taskStats = new TaskStats(tasks);
                    System.out.println("\uD83C\uDF8F  Overall stats:");
                    System.out.println("Total tasks: " + taskStats.getTotalTasks());
                    System.out.println("Avg priority: " + taskStats.getAveragePriority());
                    break;
                }
                case "categoryStats": {
                    if (args.length == 2) {
                        String categoryName = args[1];
                        for (TaskCategory category : taskCategories) {
                            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                                System.out.println("\uD83C\uDF8F Stats for Category: " + categoryName);
                                System.out.println("Total tasks: " + category.getTotalTasks());
                                System.out.println("Average priority: " + category.getAveragePriority());
                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid arguments. Usage: categoryStats <category name>");
                    }
                    break;
                }
                case "compareTasksByDeadline": {
                    if (args.length == 3) {
                        String task1Title = args[1];
                        String task2Title = args[2];
                        // find each task by title in task array
                        if (taskManager.findTask(task1Title) != null && taskManager.findTask(task2Title ) != null) {
                            Task task1 = taskManager.findTask(task1Title);
                            Task task2 = taskManager.findTask(task2Title);
                            // first we compare deadlines and handle if theyre diff
                            if (!task1.getDeadline().equals(task2.getDeadline())) {
                                int comparisonByDeadline = task1.compareTo(task2);
                                if (comparisonByDeadline < 0) {
                                    System.out.println("\uD83D\uDDD3\uFE0F  "+ task1.getTitle() + " has an earlier deadline than " + task2.getTitle() + "\n");
                                } else if (comparisonByDeadline > 0) {
                                    System.out.println("\uD83D\uDDD3\uFE0F  " + task1.getTitle() + " has a later deadline than " + task2.getTitle() + "\n");
                                }
                            }
                            // if deadlines are the same comparison is based on priority
                            else {
                                int comparisonByPriority = task1.compareTo(task2);
                                if (comparisonByPriority < 0) {
                                    System.out.println("⚠️ " + task1.getTitle() + " has a lower priority than " + task2.getTitle() + "\n");
                                } else if (comparisonByPriority > 0) {
                                    System.out.println("⚠️ " + task1.getTitle() + " has a higher priority than " + task2.getTitle() + "\n");
                                } else {
                                    System.out.println("⚠️ " + task1.getTitle() + " has the same priority as " + task2.getTitle() + "\n");
                                }
                            }
                        }
                        else
                        {
                            System.out.println("One or both tasks not found.");
                        }
                    }
                    else
                    {
                        System.out.println("Invalid arguments. Usage: compareTasksByDeadline <task1Title> <task2Title>");
                    }
                    break;
                }
                case "sortTasksByDeadline": {
                    // use compareTo from Task
                    Arrays.sort(tasks);
                    System.out.println("\n\uD83D\uDC7E  Tasks sorted by deadline:");
                    {
                        for (Task task : tasks)
                        {
                            if (task != null)
                            {
                                System.out.println("  - " + task);
                            }
                        }
                    }
                    System.out.println();
                    break;
                }
                case "compareCategoriesByNoOfTasks": {
                    {
                        if (args.length == 3)
                        {
                            System.out.println();
                            String category1Title = args[1];
                            String category2Title = args[2];
                            // find the 2 categories
                            if (taskManager.findCategory(category1Title) != null && taskManager.findCategory(category2Title) != null) {
                                int comparisonByNoResult = category1Title.compareTo(category2Title);
                                if (comparisonByNoResult < 0) {
                                    System.out.println("\uD83D\uDCC2  Category " + category1Title + " has less tasks than " + category2Title + "\n");
                                }
                                else if (comparisonByNoResult > 0) {
                                    System.out.println("\uD83D\uDCC2  Category " + category1Title + " has more tasks than " + category2Title + "\n");
                                }
                                else
                                {
                                    System.out.println("\uD83D\uDCC2  Category " + category1Title + " has as many tasks as " + category2Title + "\n");
                                }
                            }
                            else
                            {
                                System.out.println("One of the two categories could not be found.");
                            }
                        }
                        else
                        {
                            System.out.println("Invalid usage. Usage: compareCategoriesByNoOfTasks <category1 name> <category2 name>");
                        }
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid command. Use no args to see available options.");
                    break;
                }

            }
        }
        System.out.println("\n\uD83C\uDF2A  Existing tasks in Task Categories:");
        for (TaskCategory category : taskCategories) {
            System.out.println("\n📂 Category: " + category.getCategoryName());
            Task[] tasksInCategory = category.getTasks();
            System.out.println("  - Tasks in this category:");
            for (Task task : tasksInCategory) {
                if (task != null) {
                    System.out.printf("    - [%d] %s: %s (Due: %s)\n",
                            task.getPriority(), task.getTitle(),
                            task.getDescription(), task.getDeadline());
                }
                }
            }
        }
    }
