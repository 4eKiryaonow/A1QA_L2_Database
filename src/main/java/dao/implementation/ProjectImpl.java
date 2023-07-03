package dao.implementation;

import dao.model.ProjectDAO;
import model.sql.Project;
import utils.InfoLogger;
import utils.sql.ConnectionDatabase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static constants.sql.DatabaseConstants.NAME_DB;
import static constants.sql.TableNameConstants.AUTHOR_TABLE_NAME;
import static constants.sql.TableNameConstants.PROJECT_TABLE_NAME;
import static constants.sql.index.IndexTableProject.INDEX_NAME;
import static constants.sql.key.KeyTableProject.ID_KEY;
import static constants.sql.key.KeyTableProject.NAME_KEY;
import static constants.sql.query.QueryTableProject.GET_BY_NAME;
import static constants.sql.query.QueryTableProject.INSERT;

public class ProjectImpl implements ProjectDAO {
    @Override
    public void add(Project project) {
        String query = String.format(INSERT, PROJECT_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(INDEX_NAME, project.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public void update(Project project) {
    }

    @Override
    public void delete(Project project) {
    }

    @Override
    public Project getById(long id) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project getByName(String projectName) {
        String query = String.format(GET_BY_NAME, NAME_DB, PROJECT_TABLE_NAME);
        PreparedStatement preparedStatement = ConnectionDatabase.prepareStatement(query);
        try {
            preparedStatement.setString(INDEX_NAME, projectName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Project(
                        resultSet.getLong(ID_KEY),
                        resultSet.getString(NAME_KEY)
                );
            } else {
                return new Project();
            }
        } catch (SQLException e) {
            InfoLogger.error(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            ConnectionDatabase.closeStatement(preparedStatement);
        }
    }

    @Override
    public boolean isCreated(Project project) {
        return !Objects.isNull(getByName(project.getName()));
    }
}