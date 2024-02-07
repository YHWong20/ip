public class Event extends Task {
    private final String startDate;
    private final String endDate;

    private Event(String taskName, int taskId, boolean isCompleted, String startDate, String endDate) {
        super(taskName, taskId, isCompleted);
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Event(String taskName, int taskId, String startDate, String endDate) {
        super(taskName, taskId, false);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Task completeTask() {
        return new Event(this.taskName, this.taskId, true, this.startDate, this.endDate);
    }

    public Task uncompleteTask() {
        return new Event(this.taskName, this.taskId, false, this.startDate, this.endDate);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + String.format(" (from: %s to: %s)", this.startDate, this.endDate);
    }
}