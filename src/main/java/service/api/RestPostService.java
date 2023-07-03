package service.api;

import io.restassured.response.Response;
import model.api.dto.Post;
import utils.api.RestUtil;

import java.util.Arrays;
import java.util.List;

import static constants.api.EndPoints.GET_POST;
import static constants.api.EndPoints.POSTS;

public class RestPostService {
    public Response getPostsResponse() {return RestUtil.getNoParams(POSTS);}

    public List<Post> getPostList() {
        return Arrays.asList(getPostsResponse().getBody().as(Post[].class));
    }

    public Post getPost(String postId) {
        return getPostResponse(postId).body().as(Post.class);
    }

    public Response getPostResponse(String postId) {
        return RestUtil.getNoParams(String.format(GET_POST, postId));
    }

    public Response postNewPostResponse(Post post) {
        return RestUtil.postWithBody(POSTS, post);
    }

    public Post postNewPost(Response response) {
        return response.body().as(Post.class);
    }
}