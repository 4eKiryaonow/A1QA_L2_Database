package hoard;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import model.api.dto.User;
import model.sql.Author;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.InfoLogger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

import static constants.sql.key.KeyDataConstants.AUTHOR_KEY;

public class JsonReader {
    private static JSONParser reader = new JSONParser();

    public static String getValue(String path, String keyName) {
        String value;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            JSONObject jsonObject = (JSONObject) reader.parse(bufferedReader);
            value = jsonObject.get(keyName).toString();
        } catch (Exception e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return value;
    }

    public static Author getAuthor(String path) {
        Author author;
        Gson gson = new Gson();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            JsonObject jsonObject = gson.fromJson(bufferedReader, JsonObject.class);
            JsonObject authorObject = jsonObject.getAsJsonObject(AUTHOR_KEY);
            author = gson.fromJson(authorObject, Author.class);
        } catch (Exception e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return author;
    }
    public static Map<String, User> getUser(String path) {
        Map<String, User> dataFromJsonFile;
        Gson gson = new Gson();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            Type type = new TypeToken<Map<String, User>>() {
            }.getType();
            dataFromJsonFile = gson.fromJson(bufferedReader, type);
        } catch (Exception e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return dataFromJsonFile;
    }
}