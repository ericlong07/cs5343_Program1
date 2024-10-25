
/**
 * Priority with Round Robin (PriorityRR) scheduling algorithm.
 */
import java.util.*;

public class PriorityRR implements Algorithm
{
    private List<Task> queue;
    private int timeSlice;
    private int currentHighestPriority;
    
    public PriorityRR(List<Task> queue) {
        this.queue = queue;
        this.timeSlice = 10;
        this.currentHighestPriority = findHighestPriority();
    }
    
    private int findHighestPriority() {
        return queue.stream()
            .mapToInt(Task::getPriority)
            .max()
            .orElse(Integer.MIN_VALUE);
    }
    
    @Override
    public void schedule() {
        System.out.println("Priority Round Robin Scheduling\n");
        
        while (!queue.isEmpty()) {
            Task currentTask = pickNextTask();
            int executeTime = Math.min(timeSlice, currentTask.getBurst());
            
            CPU.run(currentTask, executeTime);
            currentTask.setBurst(currentTask.getBurst() - executeTime);
            
            if (currentTask.getBurst() <= 0) {
                queue.remove(currentTask);
                currentHighestPriority = findHighestPriority();
            } else {
                // Move to end of queue for round robin
                queue.remove(currentTask);
                queue.add(currentTask);
            }
        }
    }
    
    @Override
    public Task pickNextTask() {
        // Find next task with current highest priority
        for (Task task : queue) {
            if (task.getPriority() == currentHighestPriority) {
                return task;
            }
        }
        // If no task found with current priority, update to next highest priority
        currentHighestPriority = findHighestPriority();
        return pickNextTask();
    }
}
