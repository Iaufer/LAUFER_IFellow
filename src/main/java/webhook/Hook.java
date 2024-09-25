package webhook;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Дано;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import tools.ConfigReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class Hook {
    @Before
    @Дано("Открываем сайт")
    public void initBrowse() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserSize = null;
        Configuration.browserCapabilities = options;
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 20000;
        Selenide.open(ConfigReader.confData().getProperty("url"));
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }
}
