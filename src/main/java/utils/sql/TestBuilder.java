package utils.sql;

import hoard.sql.DataManager;
import model.sql.Author;
import model.sql.Project;
import model.sql.Session;
import model.sql.Test;
import org.testng.ITestResult;
import service.sql.ServiceTest;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class TestBuilder {
    public static Test getTestResult(ITestResult iTestResult) {
        Session session = SessionBuilder.getSessionFromDB(iTestResult);
        Project project = ProjectBuilder.getProjectFromBD();
        Author author = AuthorBuilder.getAuthorFromDB();
        Test testResult = new Test();
        testResult.setName(iTestResult.getName());
        testResult.setStatusId(iTestResult.getStatus());
        testResult.setMethodName(iTestResult.getMethod().getMethodName());
        testResult.setProjectId(project.getId());
        testResult.setSessionId(session.getId());
        testResult.setStartTime(new Timestamp(iTestResult.getStartMillis()));
        testResult.setEndTime(new Timestamp(iTestResult.getEndMillis()));
        testResult.setEnv(DataManager.getEnv());
        testResult.setBrowser(DataManager.getBrowser());
        testResult.setAuthorId(author.getId());
        return testResult;
    }

    public static List<Test> getTestListByListId(List<Long> listId) {
        ServiceTest serviceTest = new ServiceTest();
        return listId
                .stream()
                .map(serviceTest::getTest)
                .collect(Collectors.toList());
    }

    public static List<Test> getPrepareTestList(List<Test> testListToBePrepared) {
        testListToBePrepared
                .stream()
                .forEach(test -> {
                            test.setAuthorId(AuthorBuilder.getAuthorFromDB().getId());
                            test.setProjectId(ProjectBuilder.getProjectFromBD().getId());
                        }
                );
        return testListToBePrepared;
    }
}