package bot;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class BOTConfig {

    public static final String CHROME_LOG_FILENAME = "/home/gjcode/.config/google-chrome/chrome_debug.log";
    public static final String POSITION_CONFIG_FILE_NAME = "config.json";
    private static final String RESULTS_TEMP_FILE = "results.txt";
    private static final String LOG_FILE_NAME = "logs.txt";
    private static Map<String, PositionConfig> positionConfigs;
    private static String botPath;

    private BOTConfig() {
        // no op
    }

    public static void setBotPath(String botPath) {
        BOTConfig.botPath = botPath;
    }

    public static String getBotPath() {return botPath;}

    public static void readPositionConfig(String filePath) throws FileNotFoundException {

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(new FileReader(filePath));
        JsonArray jsonArray = jsonElement.getAsJsonArray();

        Gson gson = new Gson();
        positionConfigs = new HashMap<>();

        for (JsonElement element : jsonArray) {
            PositionConfig config = gson.fromJson(element, PositionConfig.class);
            positionConfigs.put(config.getKey(), config);
        }
    }

    public static PositionConfig getPositionConfig(String key) throws FileNotFoundException {
        if ( positionConfigs == null || positionConfigs.isEmpty()) {
            readPositionConfig(String.join("/", botPath, POSITION_CONFIG_FILE_NAME));
        }
        return positionConfigs.get(key);
    }

    public static String getResultsTempFile() {
        return String.join("/", botPath, RESULTS_TEMP_FILE);
    }

    public static String getLogFileName() {
        return String.join("/", botPath, LOG_FILE_NAME);
    }
}
