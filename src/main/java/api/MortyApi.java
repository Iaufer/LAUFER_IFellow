package api;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import tools.Prop;

import static io.restassured.RestAssured.given;

public class MortyApi {

    private final String BASE_URL;

    public MortyApi() {
        Prop config = Prop.getInstance();
        this.BASE_URL = config.BASE_URL();
    }

    public JSONObject getCharacterJson(String characterName) {
        Response response = given()
                .baseUri(BASE_URL)
                .queryParam("name", characterName)
                .when()
                .get("character")
                .then()
                .statusCode(200)
                .extract().response();

        JSONObject jsonResponse = new JSONObject(response.asString());
        JSONArray results = jsonResponse.getJSONArray("results");
        return results.length() > 0 ? results.getJSONObject(0) : null;
    }

    public JSONObject getEpisodeJson(String episodeUrl) {
        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get(episodeUrl)
                .then()
                .statusCode(200)
                .extract().response();

        return new JSONObject(response.asString());
    }

    public JSONObject getCharacterJsonByUrl(String characterUrl) {
        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get(characterUrl)
                .then()
                .statusCode(200)
                .extract().response();

        return new JSONObject(response.asString());
    }
}
