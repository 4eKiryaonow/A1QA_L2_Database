import org.testng.annotations.DataProvider;

public class TestDataProvider extends ProcessingTestDataBaseTest {
    @DataProvider(name = "Test data")
    public static Object[][] TestDataProvider() {
        Object[][] objects = new Object[copyList.size()][];
        for (int i = 0; i < copyList.size(); i++) {
            objects[i] = new Object[1];
            objects[i][0] = copyList.get(i);
        }
        return objects;
    }
}