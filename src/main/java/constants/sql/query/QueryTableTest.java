package constants.sql.query;

public class QueryTableTest {
    public static final String GET_ALL = "SELECT id, name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id FROM %s.%s";
    public static final String GET = "SELECT id, name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id FROM %s.%s WHERE id= ?";
    public static final String INSERT = "INSERT INTO %s (name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE = "UPDATE %s SET name = ?, status_id = ?, method_name = ?, project_id = ?, session_id = ?, start_time = ?, end_time = ?, env = ?, browser = ?, author_id = ? WHERE id = ?";
    public static final String GET_BY_ID_REGEX = "SELECT id, name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id FROM %s.%s WHERE id REGEXP ?";
}