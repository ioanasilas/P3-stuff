import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
        // task manager
        TaskManager taskManager = new TaskManager(null, taskCategories);

        // adding tasks manually to see both add and remove work in the same run
        taskManager.addTask("Programming 3", "Do Java HW (Meta)", 2, LocalDate.of(2024, 10, 25), "Uni Stuff");
        taskManager.addTask("Go Gym", "Stop rotting in bed", 2, LocalDate.of(2024, 10, 24), "Health");
        taskManager.addTask("Combinatorics", "Do Lecture 4 HW", 2, LocalDate.of(2024, 10, 29), "Uni Stuff");
        taskManager.addTask("Operating Systems", "Stop crying, finish dir traversal program", 2, LocalDate.of(2024, 10, 27), "Uni Stuff");
        taskManager.addTask("Operating Systems", "Cry a river", 1, LocalDate.of(2024, 10, 26), "Uni Stuff");
        taskManager.addTask("Combinatorics", "Forget what a permutation is", 3, LocalDate.of(2024, 10, 28), "Uni Stuff");


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
                        System.out.println("❌ Invalid arguments. Usage: filterTaskByPriority <priority>");
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
                default: {
                    System.out.println("Invalid command. Use no args to see available options.");
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
