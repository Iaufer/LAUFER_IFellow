package webhooks;

import ConfigManager.ConfigManager;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.PageLoadStrategy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebHook {
    private final String URL = ConfigManager.getUrl();
    private final String chromeDriverPath = ConfigManager.getChromeDriverPath();

    @BeforeEach
    public void initBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        Configuration.browserSize = null;
        Configuration.browserCapabilities = options;
        Configuration.pageLoadStrategy = PageLoadStrategy.NORMAL.toString();
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 60000;

        if (chromeDriverPath != null && !chromeDriverPath.isEmpty()) {
            Path chromeDriverFilePath = Paths.get(chromeDriverPath);
            if (Files.exists(chromeDriverFilePath)) {
                System.setProperty("webdriver.chrome.driver", chromeDriverFilePath.toString());
                System.out.println("Запуск ChromeDriver из файла: " + chromeDriverPath);
            } else {
                throw new IllegalArgumentException("Файл ChromeDriver не найден по указанному пути: " + chromeDriverPath);
            }
        } else {
            System.out.println("Используется стандартный драйвер Selenide (Т. к путь к ChromeDriver не указан)");
            Configuration.browser = "chrome";
        }


        Selenide.open(URL);
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
