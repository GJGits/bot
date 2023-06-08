package bot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

enum LogLevel {
    INFO,
    OK,
    ERROR
}

public class LogUtility {

    public static void log(String message) throws IOException {

        // Create a Path object representing the file
        Path file = Path.of(BOTConfig.getLogFileName());

        // Open the file for appending using try-with-resources
        try (var writer = Files.newBufferedWriter(file, StandardOpenOption.APPEND)) {
            // Append content to the file
            writer.write(message + "\n");
        }
    }

}
