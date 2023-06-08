package bot;

public interface Bot {
    public void init() throws Exception;
    public void run() throws InterruptedException;
    public void stop();
    public void restart();
}
