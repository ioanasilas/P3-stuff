public class TaskStats implements Statsable{
    private Task[] tasks;

    public TaskStats(Task[] tasks)
    {
        this.tasks = tasks;
    }

    // we get tasks across all categories here
    @Override
    public int getTotalTasks()
    {
        int count = 0;
        for(Task task : tasks)
        {
            if (task != null)
            {
                count++;
            }
        }
        return count;
    }

    // avg priority across all categories
    @Override
    public double getAveragePriority() {
        if (tasks.length == 0)
        {
            return 0;
        }
        int totalPriority = 0;
        int count = 0;
        for (Task task : tasks)
        {
            if (task != null)
            {
                totalPriority += task.getPriority();
                count++;
            }
        }
        return (double) totalPriority / count;
    }
}
