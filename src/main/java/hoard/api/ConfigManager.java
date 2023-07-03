package hoard.api;

import hoard.ConfigReader;
import org.json.simple.JSONObject;

import java.util.Objects;

import static constants.api.KeyConfigConstants.BASE_URL_KEY;
import static constants.api.PathConstants.PATH_TO_CONFIG;

public class ConfigManager {
    private static JSONObject config;

    public static JSONObject getConfig() {
        if (Objects.isNull(config)) {
            config = ConfigReader.readConfig(PATH_TO_CONFIG);
        }
        return config;
    }

    public static String getBaseUrl() {
        return getConfig().get(BASE_URL_KEY).toString();
    }
}