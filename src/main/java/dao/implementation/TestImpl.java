package dao.implementation;

import dao.model.TestDao;
import model.sql.Test;
import utils.InfoLogger;
import utils.sql.ConnectionDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constants.sql.DatabaseConstants.NAME_DB;
import static constants.sql.TableNameConstants.TEST_TABLE_NAME;
import static constants.sql.index.IndexTableTest.*;
import static constants.sql.key.KeyTableTest.*;
import static constants.sql.query.QueryCommon.DELETE;
import static constants.sql.query.QueryCommon.GET_LAST_INSERT_ID;
import static constants.sql.query.QueryTableTest.*;

public class TestImpl implements TestDao {
    @Override
    public void add(Test test) {
        String query = String.format(INSERT, TEST_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(NAME_INDEX, test.getName());
            preparedStatement.setLong(STATUS_ID_INDEX, test.getStatusId());
            preparedStatement.setString(METHOD_NAME_INDEX, test.getMethodName());
            preparedStatement.setLong(PROJECT_ID_INDEX, test.getProjectId());
            preparedStatement.setLong(SESSION_ID_INDEX, test.getSessionId());
            preparedStatement.setTimestamp(START_TIME_INDEX, test.getStartTime());
            preparedStatement.setTimestamp(END_TIME_INDEX, test.getEndTime());
            preparedStatement.setString(ENV_INDEX, test.getEnv());
            preparedStatement.setString(BROWSER_INDEX, test.getBrowser());
            preparedStatement.setLong(AUTHOR_ID_INDEX, test.getAuthorId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Test test) {
        String query = String.format(UPDATE, TEST_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(NAME_INDEX, test.getName());
            preparedStatement.setLong(STATUS_ID_INDEX, test.getStatusId());
            preparedStatement.setString(METHOD_NAME_INDEX, test.getMethodName());
            preparedStatement.setLong(PROJECT_ID_INDEX, test.getProjectId());
            preparedStatement.setLong(SESSION_ID_INDEX, test.getSessionId());
            preparedStatement.setTimestamp(START_TIME_INDEX, test.getStartTime());
            preparedStatement.setTimestamp(END_TIME_INDEX, test.getEndTime());
            preparedStatement.setString(ENV_INDEX, test.getEnv());
            preparedStatement.setString(BROWSER_INDEX, test.getBrowser());
            preparedStatement.setLong(AUTHOR_ID_INDEX, test.getAuthorId());
            preparedStatement.setLong(UPDATE_ID_INDEX, test.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Test test) {
        String query = String.format(DELETE, NAME_DB, TEST_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setLong(DELETE_ID_INDEX, test.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public Test getById(long id) {
        String query = String.format(GET, NAME_DB, TEST_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setLong(GET_ID_INDEX, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Test(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(NAME_KEY),
                        resultSet.getLong(STATUS_ID_KEY),
                        resultSet.getString(METHOD_NAME_KEY),
                        resultSet.getLong(PROJECT_ID_KEY),
                        resultSet.getLong(SESSION_ID_KEY),
                        resultSet.getTimestamp(START_TIME_KEY),
                        resultSet.getTimestamp(END_TIME_KEY),
                        resultSet.getString(ENV_KEY),
                        resultSet.getString(BROWSER_KEY),
                        resultSet.getLong(AUTHOR_ID_KEY)
                );
            } else {
                throw new RuntimeException();
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public List<Test> getAll() {
        String query = String.format(GET_ALL, NAME_DB, TEST_TABLE_NAME);
        List<Test> testList = new ArrayList<>();
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                testList.add(new Test(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(NAME_KEY),
                        resultSet.getLong(STATUS_ID_KEY),
                        resultSet.getString(METHOD_NAME_KEY),
                        resultSet.getLong(PROJECT_ID_KEY),
                        resultSet.getLong(SESSION_ID_KEY),
                        resultSet.getTimestamp(START_TIME_KEY),
                        resultSet.getTimestamp(END_TIME_KEY),
                        resultSet.getString(ENV_KEY),
                        resultSet.getString(BROWSER_KEY),
                        resultSet.getLong(AUTHOR_ID_KEY)
                ));
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
        return testList;
    }

    @Override
    public long getLastInsertId() {
        String query = String.format(GET_LAST_INSERT_ID, NAME_DB, TEST_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(LAST_ID_KEY);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public List<Test> getTestListByIdRegEx(String regExp) {
        String query = String.format(GET_BY_ID_REGEX, NAME_DB, TEST_TABLE_NAME);
        List<Test> testList = new ArrayList<>();
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(GET_ID_INDEX, regExp);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                testList.add(new Test(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(NAME_KEY),
                        resultSet.getLong(STATUS_ID_KEY),
                        resultSet.getString(METHOD_NAME_KEY),
                        resultSet.getLong(PROJECT_ID_KEY),
                        resultSet.getLong(SESSION_ID_KEY),
                        resultSet.getTimestamp(START_TIME_KEY),
                        resultSet.getTimestamp(END_TIME_KEY),
                        resultSet.getString(ENV_KEY),
                        resultSet.getString(BROWSER_KEY),
                        resultSet.getLong(AUTHOR_ID_KEY)
                ));
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
        return testList;
    }
}