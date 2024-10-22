
/**
 * SJF scheduling algorithm (Shortest Job First).
 */
import java.util.*;

public class SJF implements Algorithm
{
    private List<Task> queue;

    public SJF(List<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void schedule() {
        System.out.println("SJF Scheduling\n");

        while (!queue.isEmpty()) {
            Task currentTask = pickNextTask();
            CPU.run(currentTask, currentTask.getBurst());
            queue.remove(currentTask);
        }
    }

    @Override
    public Task pickNextTask() {
        return Collections.min(queue, Comparator.comparingInt(Task::getBurst));
    }
}
