import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import tools.Prop;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class FirstTaskMorty {
    Prop config = Prop.getInstance();


    private String species = "";
    private String lastSpecies = "";
    private String location = "";
    private String lastLocation = "";

    private final String BASE_URL = config.BASE_URL();
    private final String CHARACTER_NAME = config.CHARACTER_NAME();

    public void morty() {
        JSONObject mortyJson = getCharacterJson(CHARACTER_NAME);
        if (mortyJson != null) {
            String lastEpisodeUrl = getLastEpisodeUrl(mortyJson);
            JSONObject lastCharacterJson = getLastCharacterJson(lastEpisodeUrl);

            if (lastCharacterJson != null) {
                extractSpeciesAndLocation(mortyJson, lastCharacterJson);
            }
        }
    }

    private JSONObject getCharacterJson(String characterName) {
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

    private String getLastEpisodeUrl(JSONObject characterJson) {
        JSONArray episodes = characterJson.getJSONArray("episode");
        return episodes.getString(episodes.length() - 1); // URL последнег эпизода
    }

    private JSONObject getLastCharacterJson(String lastEpisodeUrl) {
        Response response = given()
                .baseUri(baseURI)
                .when()
                .get(lastEpisodeUrl)
                .then()
                .statusCode(200)
                .extract().response();

        JSONObject episodeJson = new JSONObject(response.asString());
        JSONArray charactersInEpisode = episodeJson.getJSONArray("characters");
        String lastCharacterUrl = charactersInEpisode.getString(charactersInEpisode.length() - 1);

        return getCharacterJsonByUrl(lastCharacterUrl);
    }

    private JSONObject getCharacterJsonByUrl(String characterUrl) {
        Response response = given()
                .baseUri(BASE_URL)
                .when()
                .get(characterUrl)
                .then()
                .statusCode(200)
                .extract().response();

        return new JSONObject(response.asString());
    }

    private void extractSpeciesAndLocation(JSONObject mortyJson, JSONObject lastCharacterJson) {
        this.species = mortyJson.getString("species");
        this.location = mortyJson.getJSONObject("location").getString("name");

        this.lastSpecies = lastCharacterJson.getString("species");
        this.lastLocation = lastCharacterJson.getJSONObject("location").getString("name");
    }

    public String getSpecies() {
        return species;
    }

    public String getLastSpecies() {
        return lastSpecies;
    }

    public String getLocation() {
        return location;
    }

    public String getLastLocation() {
        return lastLocation;
    }
}
