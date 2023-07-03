package step.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static org.apache.http.HttpStatus.*;

public abstract class AbstractAssertionStep {
    protected Response response;

    public AbstractAssertionStep(Response response) {
        this.response = response;
    }

    public void assertResponseStatusOK() {
        Assert.assertEquals(response.statusCode(), SC_OK, String.format("Status code is not %s", SC_OK));
    }

    public void asserResponseStatusCodeNotFound() {
        Assert.assertEquals(response.statusCode(), SC_NOT_FOUND, String.format("Status code is not %s", SC_NOT_FOUND));
    }

    public void assertResponseStatusCodeCreated() {
        Assert.assertEquals(response.statusCode(), SC_CREATED, String.format("Status code is not %s", SC_CREATED));
    }

    public void assertResponseInJsonFormat() {
        Assert.assertTrue(response.contentType().contains(ContentType.JSON.toString()), String.format("Content type is not %s", ContentType.JSON));
    }
}
