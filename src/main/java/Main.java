import bot.*;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {

    private static final int WAIT_TIME_BETWEEN_JOBS = 10000;
    private static int total;
    private static int oks;
    private static int runId;

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args != null && args.length == 3) {

            String botPath = args[0];
            String botType = args[1];
            int runningTimes = Integer.parseInt(args[2]);

            BOTConfig.setBotPath(botPath);
            BotFactory botFactory = new BotFactoryImpl();
            BotManager botManager = new BotManager(botFactory);

            // Creazione di un bot specifico
            Bot bot = botManager.createBot(botType);

            runId = new Random(Integer.MAX_VALUE).nextInt() + 1;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            LogUtility.log(String.format("Start job %s (runID = %d)", bot, runId));

            for (int i = 0; i < runningTimes; i++) {
                bot.run();
                oks++;
                Thread.sleep(WAIT_TIME_BETWEEN_JOBS);
            }

            LocalDateTime finish = LocalDateTime.now();
            Duration duration = Duration.between(now, finish);
            // Format the duration as hh:mm:ss
            long hours = duration.toHours();
            long minutes = duration.toMinutesPart();
            long seconds = duration.toSecondsPart();
            LogUtility.log(String.format("[runID = %d, %s elapse time (%02d:%02d:%02d)], Total: %d, ok: %d", runId, dtf.format(now), hours, minutes, seconds, total, oks));
            LogUtility.log("#####");

        } else {
            throw new IllegalArgumentException("Wrong parameters: <botPath> <botType> <runningTimes>");
        }

    }

}
