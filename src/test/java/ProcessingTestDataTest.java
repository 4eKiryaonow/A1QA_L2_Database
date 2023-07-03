import hoard.sql.DataManager;
import model.sql.Author;
import model.sql.Project;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class ProcessingTestDataTest extends ProcessingTestDataBaseTest {

    @Test(dataProvider = "Test data", dataProviderClass = TestDataProvider.class)
    public void processTestData(model.sql.Test test) {
        test.setStartTime(new Timestamp(System.currentTimeMillis()));
        Author currentAuthor = serviceAuthor.findAuthor(DataManager.getAuthor());
        Assert.assertEquals(test.getAuthorId(), currentAuthor.getId(), String.format("Author id should be %s", currentAuthor.getId()));
        Project currentProject = serviceProject.getProjectByName(DataManager.getProjectName());
        Assert.assertEquals(test.getProjectId(), currentProject.getId(), String.format("Project id should be %s", currentProject.getId()));
        test.setStatusId(ITestResult.SUCCESS);
        test.setEndTime(new Timestamp(System.currentTimeMillis()));
    }
}