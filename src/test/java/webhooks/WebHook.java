package webhooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;
import tools.ConfigReader;


public class WebHook {
    private static final ConfigReader Prop = ConfigReader.getInstance();

    @BeforeEach
    public void initBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserSize = null;
        Configuration.browserCapabilities = options;
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 20000;
        Selenide.open(Prop.url());
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
