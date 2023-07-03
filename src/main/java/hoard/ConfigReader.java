package hoard;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utils.InfoLogger;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConfigReader {
    private static JSONParser reader = new JSONParser();

    public static JSONObject readConfig(String path) {
        JSONObject jsonObject;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            jsonObject = (JSONObject) reader.parse(bufferedReader);
        } catch (Exception e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return jsonObject;
    }
}