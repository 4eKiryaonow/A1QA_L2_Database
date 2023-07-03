package utils.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import constants.api.EndPoints;

import static io.restassured.RestAssured.given;

public class RestUtil {

    private static RequestSpecification getRequestSpecification() {
       RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(EndPoints.BASE_URL)
                .log(LogDetail.ALL)
                .build();
        return requestSpecification;
    }

    public static Response getNoParams(String uri) {
        return given(getRequestSpecification())
                .log()
                .all(true)
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .get(uri);
    }
    public static Response postWithBody(String uri, Object body) {
        RequestSpecification requestSpecification = given(getRequestSpecification())
                .log()
                .all(true)
                .contentType(ContentType.JSON)
                .body(body);
        return requestSpecification.post(uri);
    }
}