package dao.implementation;

import dao.model.SessionDao;
import model.sql.Session;
import utils.InfoLogger;
import utils.sql.ConnectionDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static constants.sql.DatabaseConstants.NAME_DB;
import static constants.sql.TableNameConstants.SESSION_TABLE_NAME;
import static constants.sql.index.IndexTableSession.*;
import static constants.sql.key.KeyTableSession.*;
import static constants.sql.query.QueryTableSession.GET_BY_SESSION_KEY;
import static constants.sql.query.QueryTableSession.INSERT;

public class SessionImpl implements SessionDao {
    @Override
    public void add(Session session) {
        String query = String.format(INSERT, SESSION_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(SESSION_KEY_INDEX, session.getSessionKey());
            preparedStatement.setTimestamp(CREATED_TIME_INDEX, session.getCreatedTime());
            preparedStatement.setLong(BUILD_NUMBER_INDEX, session.getBuildNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Session session) {
    }

    @Override
    public void delete(Session session) {
    }

    @Override
    public Session getById(long id) {
        return null;
    }

    @Override
    public List<Session> getAll() {
        return null;
    }

    @Override
    public Session getBySessionKey(String sessionKey) {
        String query = String.format(GET_BY_SESSION_KEY, NAME_DB, SESSION_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(SESSION_KEY_INDEX, sessionKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Session(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(SESSION_KEY),
                        resultSet.getTimestamp(CREATED_TIME_KEY),
                        resultSet.getLong(BUILD_NUMBER_KEY));
            } else {
                return null;
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }
}