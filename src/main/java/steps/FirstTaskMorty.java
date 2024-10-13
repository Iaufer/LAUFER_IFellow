package steps;

import api.MortyApi;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import tools.Prop;

public class FirstTaskMorty {

    private final MortyApi mortyApi = new MortyApi();
    private final String CHARACTER_NAME = Prop.getInstance().CHARACTER_NAME();

    private String species = "";
    private String lastSpecies = "";
    private String location = "";
    private String lastLocation = "";

    @Дано("отправляю запрос на получение всех персонажей")
    public void getInfoMorty(){
        morty();
    }

    @Если("Морти найден")
    public void isMortyFound(){
        if(!morty()){
            throw new RuntimeException("Персонаж Морти не найден");
        }
    }

    @Тогда("получаю последний эпизод связанный с Морти")
    public void getLastEpisode(){
        JSONObject mortyJson = mortyApi.getCharacterJson(CHARACTER_NAME);
        JSONArray episodes = mortyJson.getJSONArray("episode");
        String lastEpisodeUrl = episodes.getString(episodes.length() - 1);
        getLastCharacterJson(lastEpisodeUrl);
    }

    @Тогда("получаю из последнего эпизода последнего персонажа")
    public void getLastCharacter(){
        JSONObject mortyJson = mortyApi.getCharacterJson(CHARACTER_NAME);
        String lastEpisodeUrl = getLastEpisodeUrl(mortyJson);
        getLastCharacterJson(lastEpisodeUrl);
    }

    @Тогда("получаю данные по местонахождению и расе этого персонажа")
    public void getSpeciesAndLocation(){
        JSONObject mortyJson = mortyApi.getCharacterJson(CHARACTER_NAME);
        String lastEpisodeUrl = getLastEpisodeUrl(mortyJson);
        JSONObject lastCharacterJson = getLastCharacterJson(lastEpisodeUrl);
        extractSpeciesAndLocation(mortyJson, lastCharacterJson);
    }

    @И("проверяю, что персонаж той же расы и находится там же, где и Морти, или нет")
    public void checkSpeciesAndLocation() {
        Assertions.assertEquals(species, lastSpecies);
        Assertions.assertNotEquals(location, lastLocation);
    }

    public boolean morty() {
        JSONObject mortyJson = mortyApi.getCharacterJson(CHARACTER_NAME);
        if (mortyJson != null) {
            String lastEpisodeUrl = getLastEpisodeUrl(mortyJson);
            JSONObject lastCharacterJson = getLastCharacterJson(lastEpisodeUrl);

            if (lastCharacterJson != null) {
                extractSpeciesAndLocation(mortyJson, lastCharacterJson);
                return true;
            }
        }
        return false;
    }

    private String getLastEpisodeUrl(JSONObject characterJson) {
        JSONArray episodes = characterJson.getJSONArray("episode");
        return episodes.getString(episodes.length() - 1);
    }

    private JSONObject getLastCharacterJson(String lastEpisodeUrl) {
        JSONObject episodeJson = mortyApi.getEpisodeJson(lastEpisodeUrl);
        JSONArray charactersInEpisode = episodeJson.getJSONArray("characters");
        String lastCharacterUrl = charactersInEpisode.getString(charactersInEpisode.length() - 1);
        return mortyApi.getCharacterJsonByUrl(lastCharacterUrl);
    }

    private void extractSpeciesAndLocation(JSONObject mortyJson, JSONObject lastCharacterJson) {
        this.species = mortyJson.getString("species");
        this.location = mortyJson.getJSONObject("location").getString("name");

        this.lastSpecies = lastCharacterJson.getString("species");
        this.lastLocation = lastCharacterJson.getJSONObject("location").getString("name");
    }


    //пока хз
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
