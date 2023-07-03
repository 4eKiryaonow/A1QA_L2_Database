package dao.implementation;

import dao.model.AuthorDao;
import model.sql.Author;
import utils.InfoLogger;
import utils.sql.ConnectionDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static constants.sql.DatabaseConstants.NAME_DB;
import static constants.sql.TableNameConstants.AUTHOR_TABLE_NAME;
import static constants.sql.index.IndexTableAuthor.*;
import static constants.sql.key.KeyTableAuthor.*;
import static constants.sql.query.QueryCommon.DELETE;
import static constants.sql.query.QueryTableAuthor.*;

public class AuthorImpl implements AuthorDao {
    @Override
    public void add(Author author) {
        String query = String.format(INSERT,AUTHOR_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(NAME_INDEX, author.getName());
            preparedStatement.setString(LOGIN_INDEX, author.getLogin());
            preparedStatement.setString(EMAIL_INDEX, author.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Author author) {
        String query = String.format(UPDATE, AUTHOR_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(NAME_INDEX, author.getName());
            preparedStatement.setString(LOGIN_INDEX, author.getName());
            preparedStatement.setString(EMAIL_INDEX, author.getName());
            preparedStatement.setLong(UPDATE_ID_INDEX, author.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public void delete(Author author) {
        String query = String.format(DELETE, NAME_DB, AUTHOR_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setLong(DELETE_INDEX_ID, author.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public Author getById(long id) {
        String query = String.format(GET_BY_ID, NAME_DB, AUTHOR_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setLong(GET_INDEX_ID, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Author(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(NAME_KEY),
                        resultSet.getString(LOGIN_KEY),
                        resultSet.getString(EMAIL_KEY)
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
    public List<Author> getAll() {
        String query = String.format(GET_ALL, NAME_DB, AUTHOR_TABLE_NAME);
        List<Author> authorList = new ArrayList<>();
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                authorList.add(new Author(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(NAME_KEY),
                        resultSet.getString(LOGIN_KEY),
                        resultSet.getString(EMAIL_KEY)
                ));
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
        return authorList;
    }

    @Override
    public Author getByLogin(String login) {
        String query = String.format(GET_BY_LOGIN, NAME_DB, AUTHOR_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(GET_INDEX_LOGIN, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Author(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(NAME_KEY),
                        resultSet.getString(LOGIN_KEY),
                        resultSet.getString(EMAIL_KEY)
                );
            } else {
                return new Author();
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public boolean isCreated(Author author) {
        return !Objects.isNull(getByLogin(author.getLogin()));
    }
}