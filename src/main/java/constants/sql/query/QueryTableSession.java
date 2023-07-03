package constants.sql.query;

public class QueryTableSession {
    public static final String INSERT = "INSERT INTO %s (session_key, created_time, build_number) values (?,?,?)";
    public static final String GET_BY_SESSION_KEY = "SELECT id, session_key, created_time, build_number FROM %s.%s WHERE session_key= ?";
}