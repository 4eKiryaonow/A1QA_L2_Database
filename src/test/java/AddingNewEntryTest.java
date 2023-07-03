import hoard.api.TestDataManager;
import model.api.dto.Post;
import model.api.dto.User;
import org.testng.annotations.Test;
import step.api.PostAssertionStep;
import step.api.UserAssertionStep;
import utils.InfoLogger;

public class AddingNewEntryTest extends AddingNewEntryBaseTest {

    @Test(testName = "Get all posts")
    public void getAllPostsTest() {
        InfoLogger.info("Send GET Request to get all posts (/posts)");
        response = restPostService.getPostsResponse();
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertGetAllPosts();
    }

    @Test(testName = "Get post")
    public void getPostValidIdTest() {
        InfoLogger.info(String.format("Send GET request to get post with id=%s (/posts/id)", TestDataManager.getPostValidId()));
        response = restPostService.getPostResponse(TestDataManager.getPostValidId());
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertGetPostIsValid(TestDataManager.getPostValidId(), TestDataManager.getPostUserId());
    }

    @Test(testName = "Get post by invalid id")
    public void getPostInvalidIdTest() {
        InfoLogger.info(String.format("Send GET request to get post with id=%s (/posts/id)", TestDataManager.getPostInvalidId()));
        response = restPostService.getPostResponse(TestDataManager.getPostInvalidId());
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertGetPostInvalidId(TestDataManager.getInvalidPostResponse());
    }

    @Test(testName = "Create post")
    public void createPostTest() {
        InfoLogger.info(String.format("Send POST request to create post with userId=%s and random body and random title (/posts).", TestDataManager.getUserIdToCreatePost()));
        Post expectedPost = new Post();
        expectedPost.setUserId(TestDataManager.getUserIdToCreatePost());
        expectedPost.setTitle(TestDataManager.getRandomString());
        expectedPost.setBody(TestDataManager.getRandomString());
        response = restPostService.postNewPostResponse(expectedPost);
        postAssertionStep = new PostAssertionStep(response);
        postAssertionStep.assertCreatePost(expectedPost);
    }

    @Test(testName = "Get all users", dataProvider = "User data", dataProviderClass = UserDataProvider.class)
    public void getUsersListTest(User user) {
        InfoLogger.info("Send GET request to get users (/users)");
        response = restUserService.getListUserResponse();
        userAssertionStep = new UserAssertionStep(response);
        userAssertionStep.assertGetUsersList(user);
    }

    @Test(testName = "Get user", dataProvider = "User data", dataProviderClass = UserDataProvider.class)
    public void getUserTest(User user) {
        InfoLogger.info(String.format("Send GET request to get user with id=%s (/users/id).", user.getId()));
        response = restUserService.getUserResponse(user.getId());
        userAssertionStep = new UserAssertionStep(response);
        userAssertionStep.assertGetUser(user);
    }
}