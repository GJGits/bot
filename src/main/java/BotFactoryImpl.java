import bot.Bot;
import bot.BotFactory;

public class BotFactoryImpl implements BotFactory {
    @Override
    public Bot createBot(String tipo) {
        if (tipo.equalsIgnoreCase("PHPostVideo")) {
            return new PHPostVideoBot();
        } else if (tipo.equalsIgnoreCase("TweeterPost")) {
            return new TweeterPostBot();
        }
        // Gestisci altri tipi di bot qui, se necessario
        throw new IllegalArgumentException("Tipo di bot non supportato: " + tipo);
    }
}
