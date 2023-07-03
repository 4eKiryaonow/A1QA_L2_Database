package hoard.sql;

import hoard.JsonReader;
import model.sql.Author;

import static constants.sql.PathConstants.PATH_TEST_DATA;
import static constants.sql.key.KeyDataConstants.*;

public class DataManager {
    public static String getProjectName() {
        return JsonReader.getValue(PATH_TEST_DATA, PROJECT_NAME_KEY);
    }

    public static long getBuildNumber() {
        return Long.parseLong(JsonReader.getValue(PATH_TEST_DATA, BUILD_NUMBER_KEY));
    }

    public static String getEnv() {
        return JsonReader.getValue(PATH_TEST_DATA, ENV_KEY);
    }

    public static String getBrowser() {
        return JsonReader.getValue(PATH_TEST_DATA, BROWSER_KEY);
    }

    public static Author getAuthor() {
        return JsonReader.getAuthor(PATH_TEST_DATA);
    }

    public static int getTestAmount() {
        return Integer.parseInt(JsonReader.getValue(PATH_TEST_DATA, AMOUNT_TEST_KEY));
    }
}