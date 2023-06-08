package task;

import bot.AbstractTask;
import bot.BOTConfig;
import bot.PositionConfig;
import desktop.Clicker;

import java.awt.*;
import java.io.FileNotFoundException;

public class TaskShowElementOnScreen extends AbstractTask {

    private static final int CONSOLE_X = 620;
    private static final int BROWSER_Y = 640;
    private static final int BROWSER_ARROW_STEP_WIDTH = 40;
    private static final PositionConfig browserUp;
    private static final PositionConfig browserDown;
    private static final PositionConfig browserLeft;
    private static final PositionConfig browserRight;

    static {
        try {
            browserDown = BOTConfig.getPositionConfig("browserUp");
            browserUp = BOTConfig.getPositionConfig("browserUp");
            browserLeft = BOTConfig.getPositionConfig("browserLeft");
            browserRight = BOTConfig.getPositionConfig("browserRight");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private Point pointToShow;

    public TaskShowElementOnScreen(Point pointToShow) throws FileNotFoundException {
        this.pointToShow = pointToShow;
        int x = pointToShow.x;
        int y = pointToShow.y;
        while (x<0) {
            this.actions.add(new Clicker(browserLeft.getX(), browserLeft.getY()));
            x += BROWSER_ARROW_STEP_WIDTH;
        }
        while (x>CONSOLE_X) {
            this.actions.add(new Clicker(browserRight.getX(), browserRight.getY()));
            x -= BROWSER_ARROW_STEP_WIDTH;
        }
        while (y<0) {
            this.actions.add(new Clicker(browserUp.getX(), browserUp.getY()));
            y += BROWSER_ARROW_STEP_WIDTH;
        }
        while (y> BROWSER_Y) {
            this.actions.add(new Clicker(browserDown.getX(), browserDown.getY()));
            y -= BROWSER_ARROW_STEP_WIDTH;
        }
    }

}
