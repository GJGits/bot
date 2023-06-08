package bot;

import desktop.Action;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTask implements Task{

    protected List<Task> preTasks;
    protected List<Action> actions;

    public AbstractTask() {
        this.preTasks = new ArrayList<>();
        this.actions = new ArrayList<>();
    }

    public void execute() throws InterruptedException {

        for (Task preTask : preTasks) {
            preTask.execute();
        }

        for (Action action: actions) {
            action.act();
        }
    }

}
