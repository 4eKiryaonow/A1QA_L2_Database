package utils.api;

import model.api.dto.User;

import java.util.List;

public class RestUserUtil {
    public static User getUserById(List<User> userList, String userId) {
        return userList
                .stream()
                .filter(user -> user.getId().equals(userId))
                .findFirst()
                .orElse(null);
    }
}