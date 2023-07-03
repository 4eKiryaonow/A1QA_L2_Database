package constants.sql;

import hoard.sql.ConfigManager;

public class DatabaseConstants {
    public static final String DRIVER_DB = ConfigManager.getDatabaseDriver();
    public static final String URL_DB = ConfigManager.getDataBaseUrl();
    public static final String USER_DB = ConfigManager.getDataBaseUser();
    public static final String PASSWORD_DB = ConfigManager.getDataBasePassword();
    public static final String NAME_DB = ConfigManager.getDataBaseName();
}