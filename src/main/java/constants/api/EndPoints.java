package constants.api;

import hoard.api.ConfigManager;

public final class EndPoints {
    public static final String BASE_URL = ConfigManager.getBaseUrl();
    public static final String POSTS = "posts/";
    public static final String USERS = "users/";
    public static final String GET_POST = "posts/%s";
    public static final String GET_USER = "users/%s";
}