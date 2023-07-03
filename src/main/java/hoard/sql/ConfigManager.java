package hoard.sql;

import hoard.ConfigReader;
import org.json.simple.JSONObject;

import java.util.Objects;

import static constants.sql.PathConstants.PATH_TO_CONFIG;
import static constants.sql.key.KeyConfigConstants.*;

public class ConfigManager {
    private static JSONObject config;

    public static JSONObject getConfig() {
        if (Objects.isNull(config)) {
            config = ConfigReader.readConfig(PATH_TO_CONFIG);
        }
        return config;
    }

    public static String getDataBaseUrl() {
        return String.format(getConfig().get(URL_KEY).toString(), getDataBaseName());
    }

    public static String getDatabaseDriver() {
        return getConfig().get(DRIVER_KEY).toString();
    }

    public static String getDataBaseUser() {
        return getConfig().get(USER_KEY).toString();
    }

    public static String getDataBasePassword() {
        return getConfig().get(PASSWORD_KEY).toString();
    }
    public static String getDataBaseName() {
        return getConfig().get(NAME_DB_KEY).toString();
    }
}