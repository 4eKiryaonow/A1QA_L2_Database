import hoard.JsonReader;
import model.api.dto.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

import static constants.api.PathConstants.PATH_TEST_USER;

public class UserDataProvider {
    @DataProvider(name = "User data")
    public static Object[][] UserDataProvider() {
        List<User> userList = new ArrayList<>(JsonReader.getUser(PATH_TEST_USER).values());
        Object[][] objects = new Object[userList.size()][];
        for (int i = 0; i < userList.size(); i++) {
            objects[i] = new Object[1];
            objects[i][0] = userList.get(i);
        }
        return objects;
    }
}