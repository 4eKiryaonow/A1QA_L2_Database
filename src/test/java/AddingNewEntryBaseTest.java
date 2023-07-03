import io.restassured.response.Response;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import service.api.RestPostService;
import service.api.RestUserService;
import service.sql.ServiceTest;
import step.api.PostAssertionStep;
import step.api.UserAssertionStep;
import utils.sql.ConnectionDatabase;
import utils.sql.TestBuilder;

public abstract class AddingNewEntryBaseTest {
    protected RestPostService restPostService;
    protected Response response;
    protected RestUserService restUserService;
    protected PostAssertionStep postAssertionStep;
    protected UserAssertionStep userAssertionStep;
    protected ServiceTest serviceTest;

    @BeforeMethod
    public void setUp() {
        restPostService = new RestPostService();
        restUserService = new RestUserService();
        serviceTest = new ServiceTest();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        serviceTest.createTest(TestBuilder.getTestResult(iTestResult));
        ConnectionDatabase.closeConnection();
    }
}