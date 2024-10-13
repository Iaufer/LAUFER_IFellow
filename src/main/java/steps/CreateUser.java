package steps;

import api.UserApi;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import tools.Prop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUser {

    private final Prop config = Prop.getInstance();
    private final String FILE_PATH = config.FILE_PATH();
    private String jsonBody;
    private JSONObject requestBody;
    private Response response;

    private String name;
    private String job;

    private final UserApi userApi = new UserApi();

    @Дано("Прочитать Json из файла")
    public void readJsonFromFile() throws IOException {
        jsonBody = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
    }

    @Тогда("Подготовить тело запроса")
    public void prepareRequestBody() {
        requestBody = new JSONObject(jsonBody);
        requestBody.put("name", "Tomato");
        requestBody.put("job", "Eat market");
    }

    @Тогда("Отправить запрос для создания пользователя")
    public void sendCreateUserRequest() {
        response = userApi.createUser(requestBody);
    }

    @Тогда("Проверить что статус код 200 или 201")
    public void verifyStatusCode() {
        int statusCode = response.getStatusCode();
        Assertions.assertTrue(statusCode == 200 || statusCode == 201);//с этим что делать то
    }

    @Тогда("Проверить что response имеет валидные данные по значениям key и value")
    public void verifyResponseData() {
        JSONObject jsonResponse = new JSONObject(response.asString());
        this.name = jsonResponse.getString("name");
        this.job = jsonResponse.getString("job");

        assertEquals("Tomato", this.name, "Имя пользователя неверное");
        assertEquals("Eat market", this.job, "Работа пользователя неверная");
    }
}
