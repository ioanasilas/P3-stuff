import java.time.LocalDate;

public class Task implements Comparable<Task>
{
    private String title;
    private String description;
    private int priority;
    private LocalDate deadline;

    public Task(String title, String description, int priority, LocalDate dueDate)
    {
        this.title = title;
        this.description = description;
        this.priority = priority;
        deadline = dueDate;
    }

    public String getTitle()
    {
        return title;
    }
    public String getDescription() { return description; }
    public int getPriority() { return priority; }
    public LocalDate getDeadline() { return deadline; }

    @Override
    public String toString() {
        return String.format("Task: [%s] - %s (Priority: %d, Due: %s)", title, description, priority, deadline);
    }

    @Override
    public int compareTo(Task other)
    {
        // compare by deadline first and if they are the same, compare by priority
        int deadlineComparison = this.deadline.compareTo(other.deadline);
        if (deadlineComparison != 0)
        {
            return deadlineComparison;
        }
        return Integer.compare(this.priority, other.priority);
    }
}
