
/**
 * Priority scheduling algorithm.
 */
import java.util.*;

public class Priority implements Algorithm
{
    private List<Task> queue;

    public Priority(List<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void schedule() {
        System.out.println("Priority Scheduling\n");

        while (!queue.isEmpty()) {
            Task currentTask = pickNextTask();
            CPU.run(currentTask, currentTask.getBurst());
            queue.remove(currentTask);
        }
    }

    @Override
    public Task pickNextTask() {
        return Collections.max(queue, Comparator.comparingInt(Task::getPriority));
    }
}
