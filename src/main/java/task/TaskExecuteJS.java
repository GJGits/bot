package task;

import bot.AbstractTask;
import bot.BOTConfig;
import bot.PositionConfig;
import desktop.Clicker;
import desktop.Shortcutter;
import desktop.Typer;

import java.io.FileNotFoundException;

public class TaskExecuteJS extends AbstractTask {

    private final String jsCommand;

    public TaskExecuteJS(String jsCommand) throws FileNotFoundException {
        this.jsCommand = jsCommand;
        PositionConfig clearConsolePos = BOTConfig.getPositionConfig("clearConsole");
        PositionConfig beginConsolePos = BOTConfig.getPositionConfig("beginConsole");
        this.actions.add(new Clicker(clearConsolePos.getX(), clearConsolePos.getY()));
        this.actions.add(new Clicker(beginConsolePos.getX(), beginConsolePos.getY()));
        this.actions.add(new Typer(jsCommand));
        this.actions.add(new Shortcutter("enter"));
    }

}
