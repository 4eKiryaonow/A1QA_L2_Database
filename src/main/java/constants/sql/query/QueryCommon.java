package constants.sql.query;

public class QueryCommon {
    public static final String DELETE = "DELETE FROM %s.%s WHERE id = ?";
    public static final String GET_LAST_INSERT_ID = "SELECT LAST_INSERT_ID(Id) from %s.%s order by LAST_INSERT_ID(Id) desc limit 1";
}