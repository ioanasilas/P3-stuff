import java.time.LocalDate;

public class TaskFilter implements  Filterable
{
    private Task[] tasks;
    public TaskFilter(Task[] tasks)
    {
        this.tasks = tasks;
    }

    @Override
    public Task[] filterByPriority(int priority)
    {
        Task[] matchingTasks = new Task[tasks.length];
        int count = 0;

        for (Task task : tasks)
        {
            if (task != null && task.getPriority() == priority)
            {
                matchingTasks[count++] = task;
            }
        }
        // we avoid null entries in array
        Task[] result = new Task[count];
        System.arraycopy(matchingTasks, 0, result, 0, count);
        return result;
    }

    @Override
    public Task[] filterByDeadline(LocalDate deadline) {
        Task[] matchingTasks = new Task[tasks.length];
        int count = 0;
        for (Task task : tasks)
        {
            // check if task deadline is on or before the specified deadline
            if (task != null && task.getDeadline().isBefore(deadline) || task.getDeadline().isEqual(deadline))
            {
                matchingTasks[count++] = task;
            }
        }
        // avoid null entries
        Task[] result = new Task[count];
        System.arraycopy(matchingTasks, 0, result, 0, count);
        return result;
    }

}
