package bot;

public class BotManager {
    private BotFactory botFactory;

    public BotManager(BotFactory botFactory) {
        this.botFactory = botFactory;
    }

    public Bot createBot(String tipo) {
        return botFactory.createBot(tipo);
    }

    public void deleteBot(String nome) {

    }

    public Bot getBot(String nome) {
        return null;
    }
}
