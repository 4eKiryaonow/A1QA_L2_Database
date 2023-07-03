package constants.sql.query;

public class QueryTableProject {
    public static final String INSERT = "INSERT INTO %s (name) values (?)";
    public static final String GET_BY_NAME = "SELECT id, name FROM %s.%s WHERE name= ?";
}