package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import tools.Prop;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.oneOf;

public class UserApi {

    private final String BASE_URL_CREATE_USER;

    public UserApi() {
        Prop config = Prop.getInstance();
        this.BASE_URL_CREATE_USER = config.BASE_URL_CREATE_USER();
    }

    public Response createUser(JSONObject requestBody) {
        return given()
                .baseUri(BASE_URL_CREATE_USER)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post()
                .then()
                .statusCode(oneOf(200, 201))
                .extract().response();
    }
}
