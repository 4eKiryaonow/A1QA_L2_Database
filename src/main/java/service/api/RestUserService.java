package service.api;

import model.api.dto.User;
import io.restassured.response.Response;
import utils.api.RestUtil;

import java.util.Arrays;
import java.util.List;

import static constants.api.EndPoints.GET_USER;
import static constants.api.EndPoints.USERS;

public class RestUserService {
    public Response getListUserResponse() {
        return RestUtil.getNoParams(USERS);
    }

    public List<User> getUserList() {
        return Arrays.asList(getListUserResponse().getBody().as(User[].class));
    }

    public Response getUserResponse(String userId) {
        return RestUtil.getNoParams(String.format(GET_USER, userId));
    }

    public User getUser(String userId) {
        return getUserResponse(userId).as(User.class);
    }
}