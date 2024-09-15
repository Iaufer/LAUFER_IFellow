package webhooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;


public class WebHook {
    @BeforeAll
    public static void initBrowser(){
        Selenide.open("https://edujira.ifellow.ru/");
        Configuration.timeout = 15000;     // Укажите тайм-аут

    }
    //cdp 128

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();  // Закрыть браузер после тестов
    }
}
