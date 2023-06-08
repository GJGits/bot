import bot.AbstractBot;
import bot.BOTConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class PHPostVideoBot extends AbstractBot {

    private static final String USERNAME_FILENAME = "phUsernames.txt";
    private static Set<String> alreadyProcessedUsers = new HashSet<>();

    private void loadUsernames() throws IOException {
        // Create a Path object representing the file
        Path filePath = Path.of(BOTConfig.getBotPath() + "/" + USERNAME_FILENAME);
        // Open the file for appending using try-with-resources
        // Read all lines from the file
        var lines = Files.readAllLines(filePath);

        // Process each line
        for (String line : lines) {
            String[] usernames = line.split(";");
            for (String username : usernames) {
                alreadyProcessedUsers.add(username.replaceAll("\"", ""));
            }
        }
    }

    @Override
    public void init() throws IOException {
        loadUsernames();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void restart() {

    }
}
