import hoard.sql.DataManager;
import model.sql.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import service.sql.ServiceAuthor;
import service.sql.ServiceProject;
import service.sql.ServiceTest;
import utils.sql.ConnectionDatabase;
import utils.sql.RandomUtils;
import utils.sql.TestBuilder;

import java.util.List;

public abstract class ProcessingTestDataBaseTest {
    protected ServiceTest serviceTest;
    protected static ServiceAuthor serviceAuthor;
    protected static ServiceProject serviceProject;
    protected static List<Test> initList;
    protected static List<Test> copyList;

    @BeforeSuite
    public void setUp() {
        serviceTest = new ServiceTest();
        serviceAuthor = new ServiceAuthor();
        serviceProject = new ServiceProject();
        initList = TestBuilder.getTestListByListId(RandomUtils.getRandomDoubleDigitTestIdList(DataManager.getTestAmount()));
        copyList = TestBuilder.getPrepareTestList(initList);
        for (Test test : copyList) {
            serviceTest.createTest(test);
            test.setId(serviceTest.getLastIdCreatedTest());
        }
    }

    @AfterSuite
    public void tearDown() {
        for (Test test : copyList) {
            serviceTest.removeTest(test);
        }
        ConnectionDatabase.closeConnection();
    }
}