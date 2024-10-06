package webhooks;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import tools.ConfigReader;


public class WebHook {
    private static final ConfigReader Prop = ConfigReader.getInstance();

    @BeforeAll
    public static void initBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserSize = null;
        Configuration.browserCapabilities = options;
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 20000;
        Selenide.open(Prop.url());
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
