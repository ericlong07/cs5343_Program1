
/**
 * Priority with Round Robin (PriorityRR) scheduling algorithm.
 */
import java.util.*;

public class PriorityRR implements Algorithm
{
    private List<Task> queue;
    private int timeSlice;

    public PriorityRR(List<Task> queue) {
        this.queue = queue;
        this.timeSlice = 10;  // default time slice
    }

    @Override
    public void schedule() {
        System.out.println("Priority Round Robin Scheduling\n");

        while (!queue.isEmpty()) {
            Task currentTask = pickNextTask();
            CPU.run(currentTask, Math.min(timeSlice, currentTask.getBurst()));
            currentTask.setBurst(currentTask.getBurst() - timeSlice);
            
            if (currentTask.getBurst() <= 0) {
                queue.remove(currentTask);
            } else {
                queue.add(queue.remove(0)); // move the task to the end of the queue
            }
        }
    }

    @Override
    public Task pickNextTask() {
        return Collections.max(queue, Comparator.comparingInt(Task::getPriority));
    }
}
