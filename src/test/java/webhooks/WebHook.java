package webhooks;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class WebHook {
    @BeforeAll
    public static void initBrowser(){
        Configuration.browser = Browsers.CHROME;
        Selenide.open("https://edujira.ifellow.ru/");
        getWebDriver().manage().window().maximize();
        Configuration.timeout = 15000;

    }
    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
