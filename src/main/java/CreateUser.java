import io.restassured.response.Response;
import org.json.JSONObject;
import tools.Prop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class CreateUser {

    private final Prop config = Prop.getInstance();
    private final String FILE_PATH = config.FILE_PATH();
    private final String BASE_URL_CREATE_USER = config.BASE_URL_CREATE_USER();
    private String name;
    private String job;

    public void createUserTest() {
        try {
            String jsonBody = readJsonFromFile(FILE_PATH);
            JSONObject requestBody = prepareRequestBody(jsonBody, "Tomato", "Eat maket");
            Response response = sendPostRequest(requestBody);

            processResponse(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readJsonFromFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    private JSONObject prepareRequestBody(String jsonBody, String name, String job) {
        JSONObject requestBody = new JSONObject(jsonBody);
        requestBody.put("name", name);
        requestBody.put("job", job);
        return requestBody;
    }

    private Response sendPostRequest(JSONObject requestBody) {
        return given()
                .baseUri(BASE_URL_CREATE_USER)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract().response();
    }

    private void processResponse(Response response) {
        JSONObject jsonResponse = new JSONObject(response.asString());
        this.name = jsonResponse.getString("name");
        this.job = jsonResponse.getString("job");
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
