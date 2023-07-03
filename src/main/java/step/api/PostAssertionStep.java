package step.api;


import io.restassured.response.Response;
import model.api.dto.Post;
import org.testng.Assert;
import service.api.RestPostService;
import utils.api.RestPostUtil;

import java.util.List;

public class PostAssertionStep extends AbstractAssertionStep {
    private RestPostService restPostService;

    public PostAssertionStep(Response response) {
        super(response);
        restPostService = new RestPostService();
    }

    public void assertGetAllPosts() {
        assertResponseStatusOK();
        assertResponseInJsonFormat();
        List<Post> postList = restPostService.getPostList();
        Assert.assertEquals(RestPostUtil.getSortedPostsByUserId(postList), postList, "Post list is not sorted by id");
    }

    public void assertGetPostIsValid(String postId, String userId) {
        assertResponseStatusOK();
        Post post = restPostService.getPost(postId);
        Assert.assertEquals(post.getId(), postId, "Post id doesn't match");
        Assert.assertEquals(post.getUserId(), userId, "User id in post doesn't match");
        Assert.assertNotNull(post.getTitle(), "Post title is empty");
        Assert.assertNotNull(post.getBody(), "Post body is empty");
    }

    public void assertGetPostInvalidId(String expectedResponseBody) {
        asserResponseStatusCodeNotFound();
        Assert.assertEquals(response.body().asString(), expectedResponseBody, String.format("Response is not %s", expectedResponseBody));
    }

    public void assertCreatePost(Post expectedPost) {
        Post actualPost = restPostService.postNewPost(response);
        assertResponseStatusCodeCreated();
        Assert.assertEquals(actualPost.getTitle(), expectedPost.getTitle(), "Post title doesn't match");
        Assert.assertEquals(actualPost.getBody(), expectedPost.getBody(), "Post body doesn't match");
        Assert.assertEquals(actualPost.getUserId(), expectedPost.getUserId(), "User id in post doesn't match");
        Assert.assertNotNull(actualPost.getUserId(), "Post user id is empty");
    }
}