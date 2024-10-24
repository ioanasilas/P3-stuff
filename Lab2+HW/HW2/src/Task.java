import java.time.LocalDate;

public class Task
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

    @Override
    public String toString()
    {
        return "Task [" + title + "," + " description=" + description + ", priority=" + priority + ", dueDate=" + deadline + "]";
    }
}
