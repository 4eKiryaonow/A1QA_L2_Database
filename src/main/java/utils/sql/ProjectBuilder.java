package utils.sql;

import hoard.sql.DataManager;
import model.sql.Project;
import service.sql.ServiceProject;
public class ProjectBuilder {

    public static Project buildProject() {
        Project project = new Project();
        project.setName(DataManager.getProjectName());
        return project;
    }
    public static Project getProjectFromBD() {
        Project project = buildProject();
        ServiceProject serviceProject = new ServiceProject();
        serviceProject.createProject(project);
        project = serviceProject.getProjectByName(project.getName());
        return project;
    }
}