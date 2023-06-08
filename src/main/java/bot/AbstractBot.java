package bot;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBot implements Bot {

    protected List<Task> tasks;

    public AbstractBot() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public void run() throws InterruptedException {
        for (Task task: tasks) {
            this.executeTask(task);
        }
    }

    protected void executeTask(Task task) throws InterruptedException {
        /* TODO: implementare gestione transazione in
                 questo metodo. */
        task.execute();
    }

}
