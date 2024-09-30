import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateUserTest {

    private CreateUser cUser;

    @BeforeEach
    public void setUp() {
        cUser = new CreateUser();
        cUser.createUserTest();
    }

    @Test
    @DisplayName("Проверка имени пользователя 'Tomato'")
    public void testName() {
        assertEquals("Tomato", cUser.getName());
    }

    @Test
    @DisplayName("Проверка работы пользователя 'Eat maket'")
    public void testJob() {
        assertEquals("Eat maket", cUser.getJob());
    }
}
