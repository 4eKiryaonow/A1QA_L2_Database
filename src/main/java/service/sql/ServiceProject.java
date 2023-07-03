package service.sql;

import dao.model.ProjectDAO;
import dao.implementation.ProjectImpl;
import model.sql.Project;

public class ServiceProject {
    private ProjectDAO project;

    public ServiceProject() {
        this.project = new ProjectImpl();
    }

    public void createProject(Project project) {
        if (!this.project.isCreated(project)) {
            this.project.add(project);
        }
    }

    public Project getProjectByName(String projectName) {
        return this.project.getByName(projectName);
    }
}