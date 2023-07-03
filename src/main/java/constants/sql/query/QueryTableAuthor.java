package constants.sql.query;

public class QueryTableAuthor {
    public static final String GET_ALL = "SELECT id, name, login, email FROM %s.%s";
    public static final String GET_BY_ID = "SELECT id, name, login, email FROM %s.%s WHERE id= ?";
    public static final String GET_BY_LOGIN = "SELECT id, name, login, email FROM %s.%s WHERE login= ?";
    public static final String INSERT = "INSERT INTO %s (name, login, email) values (?, ?, ?)";
    public static final String UPDATE = "UPDATE %s SET name = ?, login = ?, email = ? WHERE id = ?";
}