package dao.model;

import model.sql.Project;

public interface ProjectDAO extends GenericDao<Project>{
    Project getByName(String projectName);
    boolean isCreated(Project project);
}